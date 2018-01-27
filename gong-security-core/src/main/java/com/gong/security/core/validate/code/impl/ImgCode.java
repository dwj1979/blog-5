package com.gong.security.core.validate.code.impl;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by SNOW on 18.1.2.
 */
@Data
public class ImgCode extends ValidateCode {
    private BufferedImage img;
    public ImgCode(BufferedImage img,String code,LocalDateTime expireTime){
        super(code,expireTime);
        this.img = img;
    }

    public ImgCode(BufferedImage img,String code,int expireSecond){
        super(code,expireSecond);
        this.img = img;
    }
}
