package com.gong.security.core.validate.code.impl;

import com.gong.security.core.properties.SecurityProperties;
import com.gong.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SNOW on 2018.01.04.
 */
@Configuration
public class ValidateCodeGeneratorConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean // 这样配置在后续使用的时候可以再配置一个该BEAN,而进行配置覆盖。
    public ValidateCodeGenerator getValidateCodeGenerator() {
        ImgValidateCodeGenerator imgValidateCodeGenerator = new ImgValidateCodeGenerator();
        imgValidateCodeGenerator.setSecurityProperties(securityProperties);
        return imgValidateCodeGenerator ;
    }
}
