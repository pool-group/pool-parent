package com.my.web.controller;

import com.my.web.integration.order.OrderInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by duanp on 2018/8/4.
 */
@Controller
public class OrderController {


    @Autowired
    private OrderInfoClient orderInfoClient;


    /** 首页 */
    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/getOrder")
    @ResponseBody
    public String getOrder(){

        return orderInfoClient.getOrderInfo();
    }


}
