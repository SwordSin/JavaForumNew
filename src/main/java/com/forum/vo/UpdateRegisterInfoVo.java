package com.forum.vo;

import com.forum.common.custom.anno.DynamicType;
import com.forum.common.custom.anno.FieldMatch;
import com.forum.common.custom.anno.UpdateKeys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@UpdateKeys(updateKey = {"usename", "email", "password", "netName"}, key = "key")
@DynamicType(key = "key", value = "value")
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRegisterInfoVo {

    @Max(value = Long.MAX_VALUE, message = "输入的id格式错误")
    private Long id;

    @NotNull(message = "被修改的字段不能为空")
    private String key;

    @NotNull(message = "请输入被修改的内容")
    private String value;

}
// 修改用户的参数
