package com.player.framework.annotation.message;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageMeta {
    /**
     * 包头
     */
    int module() default 0;
    /**
     * 区分新旧
     */
    int cmd() default 0;
}
