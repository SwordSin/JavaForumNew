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
 * 朋友列表
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("friend_list")
@ApiModel(value="FriendListPojo对象", description="朋友列表")
public class FriendListPojo extends Model<FriendListPojo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户好友id")
    private Long friendId;

    @ApiModelProperty(value = "用户发送, 朋友未接受到的消息")
    private String noAcceptedMsg;

    @ApiModelProperty(value = "朋友类型: 1.好友 2.黑名单")
    private Integer friendType;

    @ApiModelProperty(value = "备用字段1")
    private String param1;

    @ApiModelProperty(value = "备用字段2")
    private String param2;

    @ApiModelProperty(value = "备用字段3")
    private String param3;

    @ApiModelProperty(value = "记录创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
