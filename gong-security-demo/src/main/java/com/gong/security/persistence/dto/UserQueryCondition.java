package com.gong.security.persistence.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * {@link com.gong.security.entity.User}.
 * Created by GongWenHua on 17.12.11.
 */
@Data
public class UserQueryCondition {
    @NotEmpty
    private String userId;
    @ApiModelProperty("用户姓名")
    private String userName;
    private Integer age;
}
