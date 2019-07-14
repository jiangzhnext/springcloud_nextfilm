package com.next.jiangzh.springboot.nextfilmorder.service.order;


import com.next.jiangzh.film.service.common.exception.CommonServiceExcetion;
import com.next.jiangzh.springboot.nextfilmorder.controller.order.vo.response.OrderDetailResVO;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OrderServiceAPI {

    /*
        检查座位是否为已售座位
     */
    void checkSoldSeats(String fieldId, String seats) throws CommonServiceExcetion;


    /*
        保存订单信息
     */
    OrderDetailResVO saveOrder(String seatIds, String seatNames, String fieldId, String userId) throws CommonServiceExcetion;

}
