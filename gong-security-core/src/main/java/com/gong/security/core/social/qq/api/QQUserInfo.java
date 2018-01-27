package com.gong.security.core.social.qq.api;

import lombok.Data;

/**
 * Created by SNOW on 2018.01.07.
 */
@Data
public class QQUserInfo {
    Integer ret;//	返回码
    String msg;//	如果ret<0，会有相应的错误信息提示，返回数据全部用UTF-8编码。
    String nickname;//	用户在QQ空间的昵称。
    String figureurl;//	大小为30×30像素的QQ空间头像URL。
    String figureurl_1;//	大小为50×50像素的QQ空间头像URL。
    String figureurl_2;//	大小为100×100像素的QQ空间头像URL。
    String figureurl_qq_1;//	大小为40×40像素的QQ头像URL。
    String figureurl_qq_2;//	大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
    String gender;//	性别。 如果获取不到则默认返回"男"
    String is_yellow_vip;//	标识用户是否为黄钻用户（0：不是；1：是）。
    String vip;//	标识用户是否为黄钻用户（0：不是；1：是）
    String yellow_vip_level;//	黄钻等级
    String level;//	黄钻等级
    String is_yellow_year_vip;//	标识是否为年费黄钻用户（0：不是； 1：是）
    String openid; //用户唯一ID
}
