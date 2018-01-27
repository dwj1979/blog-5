package com.gong.security.core.social.qq;

import com.gong.security.core.properties.QQProperties;
import com.gong.security.core.properties.SecurityProperties;
import com.gong.security.core.social.qq.api.QQ;
import com.gong.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;

/**
 * Created by SNOW on 2018.01.10.
 */
@Configuration
@ConditionalOnClass({SocialConfigurerAdapter.class, QQConnectionFactory.class})
@ConditionalOnProperty(
        prefix = "gong.security.social.qq",
        name = {"app-id"}
)
@AutoConfigureBefore({SocialWebAutoConfiguration.class})
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class QQAutoConfiguration {
    public QQAutoConfiguration() {
    }

    @Configuration
    @ConditionalOnWebApplication
    protected static class QQConfigurerAdapter extends SocialAutoConfigurerAdapter {
        private final QQProperties properties;

        @Autowired
        protected QQConfigurerAdapter(SecurityProperties securityProperties) {
            this.properties = securityProperties.getSocial().getQq();
        }

        @Bean
        @ConditionalOnMissingBean({QQ.class}) // 允许用户在进行子自定义BEAN覆盖默认行为。
        @Scope(
                value = "request",
                proxyMode = ScopedProxyMode.INTERFACES
        )
        public QQ qq(ConnectionRepository repository) {
            Connection<QQ> connection = repository.findPrimaryConnection(QQ.class);
            return connection != null ? (QQ) connection.getApi() : null;
        }

        protected ConnectionFactory<?> createConnectionFactory() {
            return new QQConnectionFactory(properties.getProviderId(), this.properties.getAppId(), this.properties.getAppSecret());
        }
    }
}
