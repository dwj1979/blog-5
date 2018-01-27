package com.gong.security.repository.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by SNOW on 2018.01.25.
 */
@Data
@MappedSuperclass
public class EntityBase {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Date createTime;
    private Date updateTime;
}
