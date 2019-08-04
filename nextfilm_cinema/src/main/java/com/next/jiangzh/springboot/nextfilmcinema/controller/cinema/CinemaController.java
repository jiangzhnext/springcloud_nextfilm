package com.next.jiangzh.springboot.nextfilmcinema.controller.cinema;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.*;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.condition.AreaResVO;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.condition.BrandResVO;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.condition.HallTypeResVO;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.request.DescribeCinemaRequestVO;
import com.next.jiangzh.springboot.nextfilmcinema.controller.cinema.vo.response.FieldInfoRequestVO;
import com.next.jiangzh.film.controller.common.BaseResponseVO;
import com.next.jiangzh.springboot.nextfilmcinema.service.cinema.CinemaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {

    @Autowired
    private CinemaServiceAPI cinemaServiceAPI;


    @RequestMapping(value = "/getFields",method = RequestMethod.GET)
    public BaseResponseVO getFields(String cinemaId){
        // 获取元数据
        List<CinemaFilmVO> cinemaFilms = cinemaServiceAPI.describeFieldsAndFilmInfo(cinemaId);
        CinemaDetailVO cinemaDetailVO = cinemaServiceAPI.describeCinemaDetails(cinemaId);

        // 组织返回参数
        List<Map<String,CinemaFilmVO>> filmList = Lists.newArrayList();

        cinemaFilms.stream().forEach((film)->{
            Map<String,CinemaFilmVO> filmVOMap = Maps.newHashMap();
            filmVOMap.put("filmInfo",film);
            filmList.add(filmVOMap);
        });

        Map<String,Object> result = Maps.newHashMap();
        result.put("cinemaInfo",cinemaDetailVO);
        result.put("filmList",filmList);

        return BaseResponseVO.success("img.nextfilm.com",result);
    }

    /*
        降级返回
     */
    public BaseResponseVO getFileInfoFallback(@RequestBody FieldInfoRequestVO requestVO){
        CinemaDetailVO cinemaDetailVO = CinemaDetailVO.builder().build();
        FieldHallInfoVO fieldHallInfoVO = new FieldHallInfoVO();
        CinemaFilmInfoVO cinemaFilmInfoVO = new CinemaFilmInfoVO();

        // 组织返回参数
        Map<String,Object> result = Maps.newHashMap();
        result.put("filmInfo",cinemaFilmInfoVO);
        result.put("cinemaInfo",cinemaDetailVO);
        result.put("hallInfo",fieldHallInfoVO);

        return BaseResponseVO.success("img.nextfilm.com",result);
    }

    @HystrixCommand(fallbackMethod = "getFileInfoFallback",
        commandProperties = {
                @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value= "4000"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
        },
        threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "1"),
                @HystrixProperty(name = "maxQueueSize", value = "10"),
                @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
                @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
                @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1500")
    })
    @RequestMapping(value = "/getFieldInfo",method = RequestMethod.POST)
    public BaseResponseVO getFieldInfo(@RequestBody FieldInfoRequestVO requestVO){
        // 获取逻辑层调用结果
        CinemaDetailVO cinemaDetailVO = cinemaServiceAPI.describeCinemaDetails(requestVO.getCinemaId());
        FieldHallInfoVO fieldHallInfoVO = cinemaServiceAPI.describeHallInfoByFieldId(requestVO.getFieldId());
        CinemaFilmInfoVO cinemaFilmInfoVO = cinemaServiceAPI.describeFilmInfoByFieldId(requestVO.getFieldId());

        // 组织返回参数
        Map<String,Object> result = Maps.newHashMap();
        result.put("filmInfo",cinemaFilmInfoVO);
        result.put("cinemaInfo",cinemaDetailVO);
        result.put("hallInfo",fieldHallInfoVO);

        return BaseResponseVO.success("img.nextfilm.com",result);
    }


    @RequestMapping(value = "/getCinemas",method = RequestMethod.GET)
    public BaseResponseVO getCinemas(DescribeCinemaRequestVO requestVO){

        Page<CinemaVO> cinemaVOPage = cinemaServiceAPI.describeCinemaInfo(requestVO);

        // 组织返回参数
        Map<String,Object> result = Maps.newHashMap();
        result.put("filmInfo",cinemaVOPage.getRecords());

        return BaseResponseVO.success(cinemaVOPage.getCurrent(),cinemaVOPage.getPages(),"img.nextfilm.com",result);
    }


    @RequestMapping(value = "/getCondition",method = RequestMethod.GET)
    public BaseResponseVO getCondition(
            @RequestParam(name = "brandId",required = false,defaultValue = "99")Integer brandId,
            @RequestParam(name = "hallType",required = false,defaultValue = "99")Integer hallType,
            @RequestParam(name = "areaId",required = false,defaultValue = "99")Integer areaId
    ){

        // 验证id是否有效
        if(!cinemaServiceAPI.checkCondition(brandId,"brand")){
            brandId = 99;
        }
        if(!cinemaServiceAPI.checkCondition(hallType,"area")){
            hallType = 99;
        }
        if(!cinemaServiceAPI.checkCondition(areaId,"hallType")){
            areaId = 99;
        }

        // 获取逻辑层结果
        List<BrandResVO> brandResVOS = cinemaServiceAPI.describeBrandConditions(brandId);
        List<AreaResVO> areaResVOS = cinemaServiceAPI.describeAreaConditions(areaId);
        List<HallTypeResVO> hallTypeResVOS = cinemaServiceAPI.describeHallTypeConditions(hallType);

        // 组织返回参数
        Map<String,Object> result = Maps.newHashMap();
        result.put("brandList",brandResVOS);
        result.put("areaList",areaResVOS);
        result.put("halltypeList",hallTypeResVOS);

        return BaseResponseVO.success(result);
    }

}
