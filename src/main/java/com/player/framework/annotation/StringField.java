package com.player.framework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringField {

    /**
     * 0.byte长度 1.short长度
     * @return
     */
    int value() default 0;

}
