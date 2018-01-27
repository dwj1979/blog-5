package com.gong.security.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Created by GongWenHua on 17.12.19.
 */
@RestController
@Slf4j
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("/sync")
    public String syncOrder() throws InterruptedException {
        log.info("主线程开始");
        Thread.sleep(1000);
        log.info("主线程结束");
        return "success";
    }

    @GetMapping("/callable")
    public Callable<String> callableOrder() {
        log.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程结束");
                return "success";
            }
        };
        log.info("主线程结束");
        return result;
    }

    @GetMapping("/deferred")
    public DeferredResult<String> deferredOrder() throws InterruptedException {
        log.info("Request received");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.placeOrder(orderNumber);
        deferredResultHolder.addDeferredResult(orderNumber,deferredResult);
        log.info("Servlet thread released");
        return deferredResult;
    }
}
