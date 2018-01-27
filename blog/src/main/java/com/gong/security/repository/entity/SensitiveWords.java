package com.gong.security.repository.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * 敏感词
 * Created by SNOW on 2018.01.18.
 */
@Data
public class SensitiveWords {
    @Id
    private String word;
}
