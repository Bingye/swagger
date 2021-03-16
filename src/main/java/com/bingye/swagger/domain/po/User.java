package com.bingye.swagger.domain.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("用户")
public class User {
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty(value = "密码",example = "1：是，2：否")
    private String password;
}
