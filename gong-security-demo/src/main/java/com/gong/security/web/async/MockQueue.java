package com.gong.security.web.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by GongWenHua on 17.12.22.
 */
@Component
@Slf4j
@Data
public class MockQueue {
    // 下单消息
    private String placeOrderMsg;
    // 订单完成消息
    private String completeOrderMsg;

    // 下单
    public void placeOrder(String placeOrderMsg) throws InterruptedException {
        new Thread(() -> {
            log.info("接到下单请求" + placeOrderMsg);
            this.placeOrderMsg = placeOrderMsg;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completeOrder(placeOrderMsg);
            log.info("订单完成" + completeOrderMsg);
        }).start();
    }

    // 订单完成
    public void completeOrder(String completeOrderMsg) {
        this.completeOrderMsg = completeOrderMsg;
    }
}
