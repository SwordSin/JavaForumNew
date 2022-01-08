package com.forum.common.custom.anno;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DynameicTypeValidator  implements ConstraintValidator<DynamicType, Object> {
    // 需要验证的参数类型
    private String key;
    // 需要验证的参数值
    private String value;

    @Override
    public void initialize(DynamicType constraintAnnotation) {
        this.key = constraintAnnotation.key();
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object src, ConstraintValidatorContext context) {
        BeanWrapperImpl wrapper = new BeanWrapperImpl(src);
        String keyVo = (String) wrapper.getPropertyValue(key);
        String valueVo = (String) wrapper.getPropertyValue(value);


        if (keyVo.equals("email")) {
            Boolean isEmail = false;
            System.out.println("请坐邮箱验证");
            String expr = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$";
            if (valueVo.matches(expr)) {
                isEmail = true;
            }
            return isEmail;
        } else {
            // "usename", "password", "netName"
            int minLen = 8;
            if (keyVo.equals("netName")) {
                minLen = 2;
            }
            int len = valueVo.length();
            if (len >= minLen && len < 20) {
                return true;
            } else {
                return false;
            }
        }
    }
}
