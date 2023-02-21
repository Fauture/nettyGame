package com.player.framework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShortField {

    /**
     * 1.写入byte长度
     * @return
     */
    int value() default 0;

}
