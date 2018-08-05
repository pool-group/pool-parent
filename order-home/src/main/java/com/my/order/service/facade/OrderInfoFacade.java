package com.my.order.service.facade;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * 对外发布接口
 *
 * Created by duanp on 2018/8/4.
 */
public interface OrderInfoFacade {

    /**
     * 获取订单信息
     *
     * @return
     */
        @GetMapping("/getOrderInfo")
        String getOrderInfo();
}
