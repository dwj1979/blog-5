package com.gong.security.core.validate.code;

/**
 * Created by SNOW on 2018.01.07.
 */
public interface SmsCodeSender {
    void send(String mobile,String code);
}

