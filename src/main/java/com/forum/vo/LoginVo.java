package com.forum.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginVo {

    @Size(min = 8, max = 20)
    @NotNull
    private String username;

    @Size(min = 8, max = 20)
    @NotNull
    private String password;

    @NotNull
    private Boolean rememberMe;
}
