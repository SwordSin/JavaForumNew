package com.forum.vo;

import com.forum.common.custom.anno.FieldMatch;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "againPassword", message = "输入的两次密码必须相同")
@Data
public class RegisterInfoVo {

    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @Size(min = 8, max = 20, message = "用户名必须大于8位且小与20位")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Size(min = 8, max = 20, message = "密码必须大于8位且小与20位")
    private String password;

    private String againPassword;

    @NotBlank(message = "昵称不能为空")
    private String netName;
//    private String headImg;
//    private String
}
