package com.forum.service.impl;

import com.forum.entity.LoginLogPojo;
import com.forum.mapper.LoginLogMapper;
import com.forum.service.LoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLogPojo> implements LoginLogService {

}
