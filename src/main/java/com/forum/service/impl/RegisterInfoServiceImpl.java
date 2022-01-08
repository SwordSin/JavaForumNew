package com.forum.service.impl;

import com.forum.common.BusisnessException;
import com.forum.common.PropertiesList;
import com.forum.common.UtilsMethod;
import com.forum.entity.RegisterInfoPojo;
import com.forum.mapper.RegisterInfoMapper;
import com.forum.service.RegisterInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.vo.RegisterInfoVo;
import com.forum.vo.UpdateRegisterInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;

/**
 * <p>
 * 用户数据表 密码使用aes算法加密解密 服务实现类
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Service
public class RegisterInfoServiceImpl extends ServiceImpl<RegisterInfoMapper, RegisterInfoPojo> implements RegisterInfoService {
    @Autowired
    private RegisterInfoServiceImpl registerInfoService;

    @Autowired
    private PropertiesList propertiesList;


    /**
     * 更新用户
     * @param updateRegisterInfoVo
     * @return
     * @auther zhegnzhipeng
     * @date 2022/01/08
     */
    @Override
    public Boolean updateRegisterInfo(UpdateRegisterInfoVo updateRegisterInfoVo) {
        System.out.println(updateRegisterInfoVo);
        RegisterInfoPojo registerInfoPojo = new RegisterInfoPojo();
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(updateRegisterInfoVo.getKey(), registerInfoPojo.getClass());
            propertyDescriptor.getWriteMethod().invoke(registerInfoPojo, updateRegisterInfoVo.getValue());
            registerInfoPojo.setId(updateRegisterInfoVo.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发生未知异常");
        }
        // 判断被修改的用户是否存在
        RegisterInfoPojo isRegisterInfoPojo = registerInfoPojo.selectById();
        Assert.notNull(isRegisterInfoPojo, "没有要被修改的用户信息");

        // 被修改的用户存在
        try {
            return registerInfoService.updateById(registerInfoPojo);
        } catch (Exception e) {
            e.printStackTrace();
            UtilsMethod.errType(e.getMessage(), propertiesList.getUqEmail());
            throw new BusisnessException(20005, "发生位置错误");
        }
    }

    /**
     * 插入用户
     * @param registerInfoVo
     * @return
     * @auther zhegnzhipeng
     * @date 2022/01/08
     */
    @Override
    public Boolean insertRegisterInfo(RegisterInfoVo registerInfoVo) {
        RegisterInfoPojo registerInfoPojo = new RegisterInfoPojo();
        BeanUtils.copyProperties(registerInfoVo, registerInfoPojo);
        try {
            return registerInfoService.save(registerInfoPojo);
        } catch (Exception e) {
            // 判断用户名是否重复
            e.printStackTrace();
            UtilsMethod.errType(e.getMessage(), propertiesList.getUqEmail());
            throw new BusisnessException(20005, "发生位置错误");
        }
    }
}
