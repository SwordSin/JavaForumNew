package com.forum.controller;

import com.forum.entity.RegisterInfoPojo;
import com.forum.service.impl.RegisterInfoServiceImpl;
import com.forum.vo.RegisterInfoVo;
import com.forum.vo.UpdateRegisterInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
        return registerInfoService.insertRegisterInfo(registerInfoVo);
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/updateOne")
    @ApiOperation(value="修改用户", notes="register")
    @ResponseBody
    public Boolean updateRegisterInfo(@RequestBody @Validated UpdateRegisterInfoVo updateRegisterInfoVo) {
        return registerInfoService.updateRegisterInfo(updateRegisterInfoVo);
    }

    /**
     * 删除用户信息
     */
    @PutMapping("/deleteOne")
    @ApiOperation(value="删除用户", notes="register")
    @ResponseBody
    public Boolean deleteRegisterInfo(@PathVariable Integer id) {
        return registerInfoService.removeById(id);
    }

}
