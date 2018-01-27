package com.gong.security.web.async;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GongWenHua on 17.12.22.
 */
@Component
public class DeferredResultHolder {

    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public DeferredResult<String> getDeferredResult(String key) {
        return map.get(key);
    }

    public void addDeferredResult(String key, DeferredResult<String> deferredResult) {
        this.map.put(key, deferredResult);
    }
}
