package com.forum.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 帖子成就表, 收藏点赞数据
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("posts_achievement")
@ApiModel(value="PostsAchievementPojo对象", description="帖子成就表, 收藏点赞数据")
public class PostsAchievementPojo extends Model<PostsAchievementPojo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "帖子id")
    private Long postsId;

    @ApiModelProperty(value = "作者id")
    private Long authId;

    @ApiModelProperty(value = "成就类型: 1.点赞 2.收藏")
    private Integer achievement;

    @ApiModelProperty(value = "点赞/收藏")
    private String achievementName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "逻辑删除1. 存在 2.删除")
    private Integer isDelete;

    @ApiModelProperty(value = "备用字段1")
    private String param1;

    @ApiModelProperty(value = "备用字段1")
    private String param2;

    @ApiModelProperty(value = "备用字段3")
    private String param3;

    @ApiModelProperty(value = "备用字段4")
    private String param4;

    @ApiModelProperty(value = "备用字段5")
    private String param5;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
