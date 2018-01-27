package com.gong.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.Locale;

/**
 * Created by SNOW on 201 8.01.25.
 */
@Data
public class ArticleVO {
    private String imgUrl;
    private String title;
    @JsonFormat(pattern = "MMM d, yyyy",locale = "en_GB")
    private Date createTime;
    private Date updateTime;
    private String content;
}
