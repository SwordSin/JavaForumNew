package com.forum.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户数据表 密码使用aes算法加密解密
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("register_info")
@ApiModel(value="RegisterInfoPojo对象", description="用户数据表 密码使用aes算法加密解密")
public class RegisterInfoPojo extends Model<RegisterInfoPojo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户昵称")
    private String netName;

    @ApiModelProperty(value = "用户头像数据")
    private String headImg;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "修改日志: 1.修改昵称  2.修改密码 3. 修改头像")
    private String modifiedLog;

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

    @TableLogic
    private Integer deleted;

}
