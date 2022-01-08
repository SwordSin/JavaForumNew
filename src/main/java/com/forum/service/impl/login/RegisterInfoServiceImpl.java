package com.forum.service.impl.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forum.common.BusisnessException;
import com.forum.common.PropertiesList;
import com.forum.common.ResultCode;
import com.forum.common.UtilsMethod;
import com.forum.entity.RegisterInfoPojo;
import com.forum.mapper.RegisterInfoMapper;
import com.forum.service.login.RegisterInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.vo.LoginVo;
import com.forum.vo.RegisterInfoVo;
import com.forum.vo.UpdateRegisterInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private UtilsMethod utilsMethod;

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
            throw new BusisnessException(ResultCode.UNKNOW_ERROR);
        }
        // 判断被修改的用户是否存在
        RegisterInfoPojo isRegisterInfoPojo = registerInfoPojo.selectById();
        Assert.notNull(isRegisterInfoPojo, "没有要被修改的用户信息");

        // 被修改的用户存在
        try {
            return registerInfoService.updateById(registerInfoPojo);
        } catch (Exception e) {
            e.printStackTrace();
            utilsMethod.errType(e.getMessage(), propertiesList.getUkEmail());
            throw new BusisnessException(ResultCode.UNKNOW_ERROR);
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
            boolean isInsert = registerInfoService.save(registerInfoPojo);
            System.out.println("打印id--------------------------");
            System.out.println(registerInfoPojo.getId());
            return isInsert;
        } catch (Exception e) {
            // 判断用户名是否重复
            e.printStackTrace();
            utilsMethod.errType(e.getMessage(), propertiesList.getUkEmail());
            throw new BusisnessException(ResultCode.UNKNOW_ERROR);
        }
    }

    @Override
    public RegisterInfoPojo loginRegisterInfo(LoginVo loginVo, HttpServletRequest req, HttpServletResponse resp) {
        QueryWrapper<RegisterInfoPojo> wrapper = new QueryWrapper<>();
        wrapper.eq("username", loginVo.getUsername()).eq("password", loginVo.getPassword());
        RegisterInfoPojo registerInfoPojo = registerInfoService.getOne(wrapper);
        System.out.println(registerInfoPojo);
        if (registerInfoPojo != null) {
            // 写入cookie
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", registerInfoPojo.getUsername());
            httpSession.setAttribute("password", registerInfoPojo.getPassword());
            // 查看是否是记住密码 记住密码,cookie保存30天, 不记住密码cookie保存2小时
            int time = 3600 * 2;
            // 记住密码功能
            if (loginVo.getRememberMe() == true) {
                time = 3600 * 24 * 30;
            }
            Cookie userPw = new Cookie("username" + registerInfoPojo.getUsername(), registerInfoPojo.getPassword());
            userPw.setPath("/");
            userPw.setMaxAge(time);
            resp.addCookie(userPw);
        } else {
            throw new BusisnessException(ResultCode.LOGIN_ERROR);
        }
        return registerInfoPojo;
    }
}
