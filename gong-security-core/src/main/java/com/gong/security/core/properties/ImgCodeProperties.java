package com.gong.security.core.properties;

import com.gong.security.core.validate.code.impl.ImgCode;
import lombok.Data;

/**
 * Created by SNOW on 18.1.3.
 */
@Data
public class ImgCodeProperties extends SmsCodeProperties {
    private int width = 67;
    private int height = 23;
}
