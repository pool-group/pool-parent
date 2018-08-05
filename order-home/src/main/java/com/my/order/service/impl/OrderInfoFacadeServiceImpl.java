package com.my.order.service.impl;

import com.my.order.service.facade.OrderInfoFacade;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by duanp on 2018/8/4.
 */
@RestController
public class OrderInfoFacadeServiceImpl implements OrderInfoFacade {

        @Override
        public String getOrderInfo(){

            return "获取订单成功";
        }
}
