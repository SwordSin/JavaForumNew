package com.forum.vo;

import com.forum.common.custom.anno.FieldMatch;
import com.forum.common.custom.anno.UpdateKeys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@UpdateKeys(updateKey = {"usename", "email", "password", "netName"}, key = "key")
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRegisterInfoVo {
    private String key;
}
// 修改用户的参数
