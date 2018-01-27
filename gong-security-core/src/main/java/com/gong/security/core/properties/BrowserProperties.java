package com.gong.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by SNOW on 17.12.27.
 */
@Data
@ConfigurationProperties(prefix = "gong.security")
public class BrowserProperties {
    private LoginType loginType = LoginType.JSON;
    private String signInPage;
}
