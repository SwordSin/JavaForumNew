package com.forum.service.impl;

import com.forum.entity.BoardInfoPojo;
import com.forum.mapper.BoardInfoMapper;
import com.forum.service.BoardInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛板块表 服务实现类
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Service
public class BoardInfoServiceImpl extends ServiceImpl<BoardInfoMapper, BoardInfoPojo> implements BoardInfoService {

}
