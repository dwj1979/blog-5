package com.gong.security.core.properties;

import lombok.Data;

/**
 * Created by SNOW on 18.1.3.
 */
@Data
public class ValidateCodeProperties {
    private SmsCodeProperties smsCode = new SmsCodeProperties();
    private ImgCodeProperties imgCode = new ImgCodeProperties();
}
