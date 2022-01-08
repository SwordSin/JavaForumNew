package com.forum.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("-----------------------insert 字段填充-----------------------------");
        if (metaObject.hasGetter("gmtCreate") && metaObject.hasGetter("gmtModified")) {
            setFieldValByName("gmtCreate", LocalDateTime.now(), metaObject);
            setFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
        }
        // 判断如果是点赞或收藏字段
        if (metaObject.hasGetter("likesNum") || metaObject.hasGetter("collectNum")) {
            setFieldValByName("likesNum", 0, metaObject);
            setFieldValByName("collectNum", 0, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("-----------------------update 字段填充-----------------------------");
        if (metaObject.hasGetter("gmtModified")) {
            setFieldValByName("gmtModified", LocalDateTime.now(), metaObject);
        }
    }
}
