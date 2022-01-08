package com.forum.service.impl;

import com.forum.entity.PostsInfoPojo;
import com.forum.mapper.PostsInfoMapper;
import com.forum.service.PostsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛文章列表 服务实现类
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Service
public class PostsInfoServiceImpl extends ServiceImpl<PostsInfoMapper, PostsInfoPojo> implements PostsInfoService {

}
