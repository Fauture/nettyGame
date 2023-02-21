package com.player.framework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LongField {
    /**
     * 1.写入int长度
     * @return
     */
    int value() default 0;

}
