package com.gong.security.entity;

/**
 * Created by GongWenHua on 17.12.11.
 */

import com.gong.security.validator.MyConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by GongWenHua on 17.12.11.
 */
@Data
@AllArgsConstructor
public class User {
    @NotBlank
    @MyConstraint(message = "测试的校验器注解")
    private String userName;
    private String userPassword;
    private String userId;
    private Integer age;
}