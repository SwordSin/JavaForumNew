package com.forum.controller;

import com.forum.common.BusisnessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"异常响应测试controller"})
@RequestMapping("/error-info")
public class ErrorController {
    /**
     * 测试异常
     */
    @PostMapping("/error1/{type}")
    @ApiOperation(value="测试异常", notes="register")
    @ResponseBody
    public String testError(@PathVariable String type) {
        System.out.println(9/0);
        if (type.equals("success")) {
            return "拿到了成功数据";
        } else {
            throw  new BusisnessException(20004, "异常数据");
        }
    }
    @PostMapping("/error2")
    @ApiOperation(value="测试异常2", notes="register")
    @ResponseBody
    public void testError2() {
        System.out.println(9/0);
    }

    @PostMapping("/error3")
    @ApiOperation(value="Assert异常测试", notes="register")
    @ResponseBody
    public Boolean testError3() {
        Assert.notNull(null, "用户不存在");
        return true;
    }

    @PostMapping("/interceptorTest/{test}")
    @ApiOperation(value="拦截器测试", notes="register")
    @ResponseBody
    public Boolean interceptorTest(@PathVariable String test) {
        System.out.println("响应数据.....");
        return true;
    }

//    @PostMapping("/testproperties")
//    @ApiOperation(value="Assert异常测试", notes="register")
//    @ResponseBody
//    public Boolean testproperties() {
//        System.out.println(propertiesList);
//        return true;
//    }
}
