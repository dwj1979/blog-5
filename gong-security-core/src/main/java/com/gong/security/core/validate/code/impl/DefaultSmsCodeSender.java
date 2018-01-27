package com.gong.security.core.validate.code.impl;

import com.gong.security.core.validate.code.SmsCodeSender;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by SNOW on 2018.01.07.
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile,String code) {
      log.debug("向"+mobile+"发送"+code);
    }
}
