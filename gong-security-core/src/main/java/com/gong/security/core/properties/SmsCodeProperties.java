package com.gong.security.core.properties;

import lombok.Data;

/**
 * Created by SNOW on 2018.01.09.
 */
@Data
public class SmsCodeProperties {
    private int length = 6;
    private int expireIn = 60;
    private String urls;
}
