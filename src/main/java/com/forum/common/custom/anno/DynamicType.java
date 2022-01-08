package com.forum.common.custom.anno;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
// 定义注解的实现类
@Constraint(validatedBy = DynameicTypeValidator.class)
@Documented
public @interface DynamicType {
    String message() default "修改的格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 需要验证的第一值
    String key();

    // 需要验证的第二个值
    String value();

}
