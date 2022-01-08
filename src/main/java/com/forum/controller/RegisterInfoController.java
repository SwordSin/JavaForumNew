package com.forum.controller;

import com.forum.common.BusisnessException;
import com.forum.entity.RegisterInfoPojo;
import com.forum.service.impl.RegisterInfoServiceImpl;
import com.forum.vo.RegisterInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
//        System.out.println(registerInfoVo);
//        return null;
        RegisterInfoPojo registerInfoPojo = new RegisterInfoPojo();
        BeanUtils.copyProperties(registerInfoVo, registerInfoPojo);
        try {
            return registerInfoService.save(registerInfoPojo);
        } catch (Exception e) {
            e.printStackTrace();
            // 打印e的信息可以获取是什么异常
            throw new BusisnessException(20005, "添加用户名重复");
        }
    }

    // 修改用户
    @PutMapping("/updateOne")
    @ApiOperation(value="修改用户", notes="register")
    @ResponseBody
    public Boolean updateRegisterInfo(@RequestBody @Validated RegisterInfoVo registerInfoVo){
        RegisterInfoPojo registerInfoPojo = new RegisterInfoPojo();
        BeanUtils.copyProperties(registerInfoVo, registerInfoPojo);
        try {
            return registerInfoService.save(registerInfoPojo);
        } catch (Exception e) {
            e.printStackTrace();
            // 打印e的信息可以获取是什么异常
            throw new BusisnessException(20005, "添加用户名重复");
        }
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
}
