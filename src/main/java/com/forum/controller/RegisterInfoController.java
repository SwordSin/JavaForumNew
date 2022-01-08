package com.forum.controller;

import com.forum.common.BusisnessException;
import com.forum.common.PropertiesList;
import com.forum.common.UtilsMethod;
import com.forum.entity.RegisterInfoPojo;
import com.forum.service.impl.RegisterInfoServiceImpl;
import com.forum.vo.RegisterInfoVo;
import com.forum.vo.UpdateRegisterInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 * 用户数据表 密码使用aes算法加密解密 前端控制器
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@RestController
@RequestMapping("/register-info")
@Api(tags = {"用户增删改查操作"})
public class RegisterInfoController {
    @Autowired
    private RegisterInfoServiceImpl registerInfoService;

//    @Autowired
//    private PropertiesList propertiesList;

    /**
     * 获取用户列表
     */
    @GetMapping("/list")
    @ApiOperation(value="获取用户列表",notes="无需参数")
    @ResponseBody
    public List<RegisterInfoPojo> getBoardInfoList(){
        return registerInfoService.list();
    }

    /*
       添加用户
    */
    @PostMapping("/saveOne")
    @ApiOperation(value="添加用户", notes="register")
    @ResponseBody
    public Boolean insertRegisterInfo(@RequestBody @Validated RegisterInfoVo registerInfoVo){
        return registerInfoService.insertRegisterInfo(registerInfoVo);
    }

    // 修改用户
    @PutMapping("/updateOne")
    @ApiOperation(value="修改用户", notes="register")
    @ResponseBody
    public Boolean updateRegisterInfo(@RequestBody @Validated UpdateRegisterInfoVo updateRegisterInfoVo) {
        return registerInfoService.updateRegisterInfo(updateRegisterInfoVo);
    }

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

//    @PostMapping("/testproperties")
//    @ApiOperation(value="Assert异常测试", notes="register")
//    @ResponseBody
//    public Boolean testproperties() {
//        System.out.println(propertiesList);
//        return true;
//    }
}
