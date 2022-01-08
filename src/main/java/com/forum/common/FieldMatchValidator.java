package com.forum.common;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object src, final ConstraintValidatorContext context) {
        // 校验的实现逻辑
        BeanWrapperImpl wrapper = new BeanWrapperImpl(src);
        Object firstObj = wrapper.getPropertyValue(firstFieldName);
        System.out.println("firstObj = " + firstObj);
        Object secondObj = wrapper.getPropertyValue(secondFieldName);
        System.out.println("secondObj = " + secondObj);

        return firstObj != null && firstObj.equals(secondObj);
    }
}
