package com.player.framework.annotation.message;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageMeta {
    /**
     * 包头
     */
    short module() default 0;
    /**
     * 区分新旧
     */
    short cmd() default 0;
}
