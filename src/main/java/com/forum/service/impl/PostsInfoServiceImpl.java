package com.forum.service.impl;

import com.forum.entity.BoardInfoPojo;
import com.forum.entity.PostsInfoPojo;
import com.forum.entity.RegisterInfoPojo;
import com.forum.mapper.PostsInfoMapper;
import com.forum.service.PostsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 论坛文章列表 服务实现类
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Service
@Slf4j
public class PostsInfoServiceImpl extends ServiceImpl<PostsInfoMapper, PostsInfoPojo> implements PostsInfoService {
    private String usuallyChinese = "一丁七万丈三上下不与丐丑专且世丘丙业丛东丝丢两严丧个中丰串临丸丹为主丽举乃久么义之乌乍乎乏乐乒乓乔乖乘乙九乞也习乡书买乱乳乾了予争事二于亏云互五井亚些亡交亥亦产亩享京亭亮亲人亿什仁仅仆仇今介仍从仑仓这是一个数";
    @Autowired
    private PostsInfoServiceImpl postsInfoService;
    @Autowired
    private RegisterInfoServiceImpl registerInfoService;
    @Autowired
    private BoardInfoServiceImpl boardInfoService;

    @Override
    public Long insertPostsInfo(PostsInfoPojo postsInfoPojo) {
        postsInfoPojo.insert();
        return null;
    }

    @Override
    public Boolean largeInsertPostsInfo(List<PostsInfoPojo> postsInfoPojos) {
        try {
            return postsInfoService.saveBatch(postsInfoPojos);
        } catch (Exception e) {
            throw new RuntimeException("批量存储文章是发生异常");
        }

    }

    @Override
    public Boolean largeInsertPostsInfo() {

        // 获取作者列表
        List<RegisterInfoPojo> registerInfoPojos = registerInfoService.list();
        // 作者数量
        int authNum = registerInfoPojos.size();
        // 获取板块列表
        List<BoardInfoPojo> boardInfoPojos = boardInfoService.list();
        // 板块数量
        int boardNum = boardInfoPojos.size();

        // 使用数组存储 PostsInfoPojo
        long startTime=System.currentTimeMillis();   //获取开始时间
        List<PostsInfoPojo> list = Collections.synchronizedList(new ArrayList<PostsInfoPojo>());

        // 创建线程阻塞队列
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        // 创建一个线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(500, 2000, 100, TimeUnit.MILLISECONDS, queue, new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10000; i++) {
            threadPoolExecutor.execute(() -> {
                // 随机获取10个汉字作为title
                StringBuilder title = new StringBuilder();
                StringBuilder content = new StringBuilder();
                for (int i1 = 0; i1 < 10; i1++) {
                    int tmp = (int) Math.floor(Math.random()*100);
                    title.append(usuallyChinese.charAt(tmp));
                }
                for (int i1 = 0; i1 < 50; i1++) {
                    int tmp = (int) Math.floor(Math.random()*100);
                    content.append(usuallyChinese.charAt(tmp));
                }
                PostsInfoPojo postsInfoPojo = new PostsInfoPojo();
                RegisterInfoPojo tmpAuth = registerInfoPojos.get((int) Math.floor(Math.random()*authNum));
                BoardInfoPojo tmpBoard = boardInfoPojos.get((int) Math.floor(Math.random()*boardNum));
                postsInfoPojo.setBoardId(tmpBoard.getId());
                postsInfoPojo.setPostsAuthId(tmpAuth.getId());
                postsInfoPojo.setPostsAuthName(tmpAuth.getNetName());
                postsInfoPojo.setPostsTitle(title.toString());
                postsInfoPojo.setPostsContent(content.toString());
                list.add(postsInfoPojo);
            });
        }
        threadPoolExecutor.shutdown();
        try {
            threadPoolExecutor.awaitTermination(Integer.MAX_VALUE,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//        System.out.println(list.size());
//        return true;
        try {
            return postsInfoService.saveBatch(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("批量保存数据出现问题");
        }
    }
}
