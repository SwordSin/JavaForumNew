package com.forum.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("discuss_list")
@ApiModel(value="DiscussListPojo对象", description="评论表")
public class DiscussListPojo extends Model<DiscussListPojo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "评论内容")
    private String dicussContent;

    @ApiModelProperty(value = "评论用户id")
    private Long discussAuthId;

    @ApiModelProperty(value = "评论用户名字")
    private String discussAuthName;

    @ApiModelProperty(value = "被评论用户id")
    private Long beDiscussAuthId;

    @ApiModelProperty(value = "被评论用户名字")
    private String beDiscussAuthName;

    @ApiModelProperty(value = "帖子id")
    private Long postId;

    @ApiModelProperty(value = "所属板块id")
    private Long boardId;

    @ApiModelProperty(value = "帖子类型")
    private String discussType;

    @ApiModelProperty(value = "备用字段1")
    private String param1;

    @ApiModelProperty(value = "备用字段2")
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
