package com.next.jiangzh.film.api.order;

import com.next.jiangzh.film.controller.common.BaseResponseVO;
import com.next.jiangzh.film.service.common.exception.CommonServiceExcetion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderFeignServiceAPI {

    @RequestMapping(value = "/feign/soldseats", method = RequestMethod.GET)
    public BaseResponseVO soldSeats(@RequestParam("fieldId") String fieldId) throws CommonServiceExcetion;

}
