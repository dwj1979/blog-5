package com.gong.security.core.social.qq.connect;

import com.gong.security.core.social.qq.adapter.QQAdapter;
import com.gong.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * Created by SNOW on 2018.01.10.
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    /**
     * @param providerId
     * @param appid
     * @param appSecret
     */
    public QQConnectionFactory(String providerId, String appid, String appSecret) {
        super(providerId, new QQServiceProvider(appid, appSecret), new QQAdapter());
    }


}
