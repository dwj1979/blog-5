package com.gong.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by SNOW on 17.12.27.
 */
@Data
@ConfigurationProperties(prefix = "gong.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();
    private SocialProperties social = new SocialProperties();
    private ServiceProperties service = new ServiceProperties();
}
