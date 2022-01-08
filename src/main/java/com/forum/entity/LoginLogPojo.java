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
 * 登录日志表
 * </p>
 *
 * @author zhengzhipeng
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("login_log")
@ApiModel(value="LoginLogPojo对象", description="登录日志表")
public class LoginLogPojo extends Model<LoginLogPojo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登录日志id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "登录用户名")
    private String username;

    @ApiModelProperty(value = "是否记住用户")
    private Integer rememberMe;

    @ApiModelProperty(value = "登录ip")
    private String ip;

    @ApiModelProperty(value = "登录时间")
    private LocalDateTime loginTime;

    @ApiModelProperty(value = "登出时间")
    private LocalDateTime logoutTime;

    @ApiModelProperty(value = "登录用户的城市")
    private String loginCity;

    @ApiModelProperty(value = "备用字段1")
    private String param1;

    @ApiModelProperty(value = "备用字段2")
    private String param2;

    @ApiModelProperty(value = "备用字段3")
    private String param3;

    @ApiModelProperty(value = "备用字段4")
    private String param4;

    @ApiModelProperty(value = "日志创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "日志修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "关闭页面时间")
    private LocalDateTime closeTime;

    @ApiModelProperty(value = "访问页面时间")
    private LocalDateTime viewTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
