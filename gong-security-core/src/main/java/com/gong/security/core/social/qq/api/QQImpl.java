package com.gong.security.core.social.qq.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * Created by SNOW on 2018.01.07.
 */
@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ{

    // 一般分为这四部，其中第一二 AbstractOAuth2ApiBinding已经帮我们做过了。
    // 剩下的 3.4 就是我们自己处理。
    // 3
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    // 4
    private static final String URL_GET_USER_INFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=&s&openid=&s";

    private String appid;

    private String openid;

    public QQImpl(String accessToken,String appid){
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appid = appid;
        String result = getRestTemplate().getForObject(String.format(URL_GET_OPENID,accessToken),String.class);
        this.openid = StringUtils.substringBetween(result,"\"openid\":\"","\"");
    }

    @Override
    public QQUserInfo getUserInfo() {
        String urlGetUserInfo =  String.format(URL_GET_USER_INFO,appid,openid);
        QQUserInfo userInfo = getRestTemplate().getForObject(urlGetUserInfo,QQUserInfo.class);
        userInfo.setOpenid(openid);
        log.debug("{}",userInfo);
        return userInfo;
    }


}
