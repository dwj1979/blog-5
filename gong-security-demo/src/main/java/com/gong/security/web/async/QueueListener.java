package com.gong.security.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 模拟消息队列监听器，将订单完成结果返回给 deferredResult
 * Created by GongWenHua on 17.12.22.
 */
@Component
@Slf4j
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(()->{
            while (true){
                if(StringUtils.isNotBlank(mockQueue.getCompleteOrderMsg())){
                    String orderNumber = mockQueue.getCompleteOrderMsg();
                    log.info("返回处理结果"+orderNumber);
                    deferredResultHolder.getDeferredResult(orderNumber).setResult("place order success");
                    mockQueue.setCompleteOrderMsg(null);
                }
            }
        }).start();

    }
}
