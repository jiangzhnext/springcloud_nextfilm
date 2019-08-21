package com.next.jiangzh.springboot.nextfilmcinema.service.cinema;

import com.next.jiangzh.film.api.order.OrderFeignServiceAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "orderService")
public interface OrderServiceAPI extends OrderFeignServiceAPI {

}
