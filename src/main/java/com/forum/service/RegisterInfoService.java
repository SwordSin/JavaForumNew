package com.forum.service;

import com.forum.entity.RegisterInfoPojo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.forum.vo.RegisterInfoVo;
import com.forum.vo.UpdateRegisterInfoVo;

/**
 * <p>
 * 用户数据表 密码使用aes算法加密解密 服务类
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
public interface RegisterInfoService extends IService<RegisterInfoPojo> {
    Boolean updateRegisterInfo(UpdateRegisterInfoVo updateRegisterInfoVo);
    Boolean insertRegisterInfo(RegisterInfoVo registerInfoVo);
}
