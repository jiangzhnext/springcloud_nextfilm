package com.next.jiangzh.film.service.order;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.next.jiangzh.film.controller.order.vo.response.OrderDetailResVO;
import com.next.jiangzh.film.controller.order.vo.response.OrderPayResVO;
import com.next.jiangzh.film.controller.order.vo.response.QRCodeResVO;
import com.next.jiangzh.film.service.common.exception.CommonServiceExcetion;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OrderServiceAPI {

    /*
        检查座位是否为已售座位
     */
    void checkSoldSeats(String fieldId,String seats) throws CommonServiceExcetion;


    /*
        保存订单信息
     */
    OrderDetailResVO saveOrder(String seatIds,String seatNames,String fieldId,String userId) throws CommonServiceExcetion;

}
