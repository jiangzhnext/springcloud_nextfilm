package com.next.jiangzh.springboot.nextfilmorder.controller.order;

import com.next.jiangzh.film.controller.common.BaseResponseVO;
import com.next.jiangzh.film.service.common.exception.CommonServiceExcetion;
import com.next.jiangzh.springboot.nextfilmorder.controller.order.vo.response.OrderDetailResVO;
import com.next.jiangzh.springboot.nextfilmorder.service.order.OrderServiceAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceAPI orderServiceAPI;

    @RequestMapping(value = "/buyTickets", method = RequestMethod.GET)
    public BaseResponseVO buyTickets(
            String userId,String fieldId, String soldSeats, String seatsName) throws CommonServiceExcetion {
        System.out.println(userId+","+fieldId+","+soldSeats+","+seatsName);
        // soldSeats 验证是否是未销售的座位
        orderServiceAPI.checkSoldSeats(fieldId, soldSeats);

        OrderDetailResVO orderDetailResVO = orderServiceAPI.saveOrder(soldSeats, seatsName, fieldId, userId);

        return BaseResponseVO.success(orderDetailResVO);
    }


}
