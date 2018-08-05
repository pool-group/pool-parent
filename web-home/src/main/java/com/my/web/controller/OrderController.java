package com.my.web.controller;

import com.my.web.integration.order.OrderInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by duanp on 2018/8/4.
 */
@RestController
public class OrderController {


    @Autowired
    private OrderInfoClient orderInfoClient;

    @GetMapping("/getOrder")
    public String getOrder(){

        return orderInfoClient.getOrderInfo();
    }


}
