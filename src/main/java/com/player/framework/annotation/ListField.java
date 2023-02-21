package com.player.framework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListField {
    /**
     * 0.short 1.byte 2.不要长度 3.int
     * @return
     */
    int value() default 0;

}
