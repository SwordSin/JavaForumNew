package com.forum.controller;


import com.forum.entity.BoardInfoPojo;
import com.forum.service.impl.PostsInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 论坛文章列表 前端控制器
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@RestController
@RequestMapping("/posts-info")
@Api(tags = {"文章列表操作"})
public class PostsInfoController {
    @Autowired
    private PostsInfoServiceImpl postsInfoService;

    /**
     * 批量存储存储
     */
    @GetMapping("/saveBach")
    @ApiOperation(value="批量存储论坛文章",notes="无需参数")
    @ResponseBody
    public Boolean getBoardInfoList(){
        return postsInfoService.largeInsertPostsInfo();
    }

}

