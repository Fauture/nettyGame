package com.player.framework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueField {
    /**
     * 属性类型
     * @return
     */
    int value() default 0;
}
