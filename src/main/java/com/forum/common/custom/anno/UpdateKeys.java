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
@Constraint(validatedBy = UpdateKeyValidator.class)
@Documented
// 更新用户名可以取值的范围
public @interface UpdateKeys {
    String message() default "请修改正确的字段";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 允许被修改的字段范围
    String[] updateKey();

    // 需要被修改的字段
    String key();
}
