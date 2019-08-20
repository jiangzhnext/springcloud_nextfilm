package com.next.jiangzh.film.api.order;

import com.next.jiangzh.film.controller.common.BaseResponseVO;
import com.next.jiangzh.film.service.common.exception.CommonServiceExcetion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "orderService")
public interface OrderFeignServiceAPI {

    @RequestMapping(value = "/soldseats", method = RequestMethod.GET)
    public BaseResponseVO soldSeats(String fieldId) throws CommonServiceExcetion;

}
