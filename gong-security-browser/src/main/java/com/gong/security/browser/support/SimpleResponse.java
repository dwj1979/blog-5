package com.gong.security.browser.support;

import lombok.Data;

/**
 * Created by GongWenHua on 17.12.26.
 */
@Data
public class SimpleResponse {
    private Object content;
    public SimpleResponse(Object content){
        this.content = content;
    }
}
