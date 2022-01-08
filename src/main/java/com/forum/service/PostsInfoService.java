package com.forum.service;

import com.forum.entity.PostsInfoPojo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 论坛文章列表 服务类
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
public interface PostsInfoService extends IService<PostsInfoPojo> {
    Long insertPostsInfo(PostsInfoPojo postsInfoPojo);

    Boolean largeInsertPostsInfo(List<PostsInfoPojo> postsInfoPojos);
    Boolean largeInsertPostsInfo();
}
