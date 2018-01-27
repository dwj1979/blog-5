package com.gong.security.core.validate.code.impl;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by SNOW on 2018.01.07.
 */
@Data
public class ValidateCode {
    private String code;
    private LocalDateTime expireTime;

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public ValidateCode(String code, int expireSecond) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireSecond);
    }

    public Boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
