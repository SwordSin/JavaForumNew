package com.forum.common.custom.anno;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class UpdateKeyValidator implements ConstraintValidator<UpdateKeys, Object> {
    private String keys[];
    private String key;


    @Override
    public void initialize(final UpdateKeys constraintAnnotation) {
        keys = constraintAnnotation.updateKey();
        key = constraintAnnotation.key();
    }

    @Override
    public boolean isValid(Object src, ConstraintValidatorContext constraintValidatorContext) {
        // 校验的实现逻辑
        BeanWrapperImpl wrapper = new BeanWrapperImpl(src);
        Object firstObj = wrapper.getPropertyValue(key);
        System.out.println(firstObj);
        return false;
    }
}
