package com.gong.security.core.social.qq.connect;

import com.gong.security.core.social.qq.api.QQ;
import com.gong.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * Created by SNOW on 2018.01.10.
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    // 1
    private static final String URL_GET_AUTH_CODE = "https://graph.qq.com/oauth2.0/authorize";
    // 2
    private static final String URL_GET_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    private String appid;

    /**
     * @param appid
     * @param appSecret
     */
    public QQServiceProvider(String appid, String appSecret) {
        super(new OAuth2Template(appid, appSecret, URL_GET_AUTH_CODE,URL_GET_ACCESS_TOKEN));
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appid);
    }
}
