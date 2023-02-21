package com.player.framework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegerField {

    /**
     * 1.写入short长度
     * @return
     */
    int value() default 0;

}
