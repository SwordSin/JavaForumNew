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
 * 论坛文章列表
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("posts_info")
@ApiModel(value="PostsInfoPojo对象", description="论坛文章列表")
public class PostsInfoPojo extends Model<PostsInfoPojo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "帖子的id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "所属板块id")
    private Integer boardId;

    @ApiModelProperty(value = "帖子标题")
    private String postsTitle;

    @ApiModelProperty(value = "帖子内容")
    private String postsContent;

    @ApiModelProperty(value = "帖子作者名字id如果为0表示匿名")
    private Integer postsAuthId;

    @ApiModelProperty(value = "帖子作者名字")
    private String postsAuthName;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private String param6;

    @ApiModelProperty(value = "乐观锁字段")
    private Integer version;

    @ApiModelProperty(value = "帖子路径")
    private String postsFilePath;

    @ApiModelProperty(value = "帖子创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "帖子修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "点赞数量")
    private Integer likesNum;

    @ApiModelProperty(value = "收藏字段")
    private Integer collectNum;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
