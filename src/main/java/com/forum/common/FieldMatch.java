package com.forum.common;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 验证两个字段的值是否相等，常见于注册时输入两个密码
 *
 * @author pancc
 * @version 1.0
 * @date 2019/11/2 17:40
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
// 定义注解的实现类
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {
    String message() default "两次输入密码不一致";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 需要验证的第一字段的字段名<code>String password</code>  中的 <code>password</code>
     *
     * @return 第一字段的字段名
     */
    String first();
    /**
     * 需要验证的第二字段的字段名<code>String confirmPassword</code>  中的 <code>confirmPassword</code>
     *
     * @return 第一字段的字段名
     */
    String second();


    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }
}
