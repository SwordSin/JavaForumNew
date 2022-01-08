package com.forum.service.impl;

import com.forum.entity.RegisterInfoPojo;
import com.forum.mapper.RegisterInfoMapper;
import com.forum.service.RegisterInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
