package com.gong.security.core.validate.code.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Created by SNOW on 2018.01.07.
 */
@Component
public class ImgValidateCodeProcessor extends AbstractValidateCodeProcessor<ImgCode> {
    @Override
    public void send(ServletWebRequest request, ImgCode validateCode) throws IOException {
        ImageIO.write(validateCode.getImg(), "JPEG", request.getResponse().getOutputStream());
    }
}
