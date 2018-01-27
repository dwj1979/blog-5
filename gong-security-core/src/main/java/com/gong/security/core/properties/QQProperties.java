package com.gong.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * Created by SNOW on 2018.01.10.
 */
@Data
public class QQProperties extends SocialProperties {
    private String providerId = "qq";
}
