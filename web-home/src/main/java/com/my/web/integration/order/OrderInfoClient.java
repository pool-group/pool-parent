package com.my.web.integration.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 集成外部接口
 *
 * Created by duanp on 2018/8/4.
 */

@FeignClient(value = "order-home")
public interface OrderInfoClient {

    /**
     * 获取订单信息
     *
     * @return
     */
    @GetMapping("/getOrderInfo")
    String getOrderInfo();
}
