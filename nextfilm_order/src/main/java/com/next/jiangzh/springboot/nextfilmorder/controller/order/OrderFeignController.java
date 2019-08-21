package com.next.jiangzh.springboot.nextfilmorder.controller.order;

import com.google.common.collect.Maps;
import com.next.jiangzh.film.api.order.OrderFeignServiceAPI;
import com.next.jiangzh.film.controller.common.BaseResponseVO;
import com.next.jiangzh.film.service.common.exception.CommonServiceExcetion;
import com.next.jiangzh.springboot.nextfilmorder.service.order.OrderServiceAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class OrderFeignController implements OrderFeignServiceAPI {

    @Autowired
    private OrderServiceAPI orderServiceAPI;

    @Override
    public BaseResponseVO soldSeats(String fieldId) throws CommonServiceExcetion {

        log.info("This is OrderFeignController-soldSeats-fieldId:{}",fieldId);

        // soldSeats 验证是否是未销售的座位
        String soldSeats = orderServiceAPI.describeSoldSeats(fieldId);

        Map<String,String> resultMap = Maps.newHashMap();
        resultMap.put("soldSeats",soldSeats);

        return BaseResponseVO.success(resultMap);
    }
}
