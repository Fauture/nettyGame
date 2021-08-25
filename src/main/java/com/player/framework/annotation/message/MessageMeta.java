package com.player.framework.annotation.message;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageMeta {
	short module() default 0;

	short cmd() default 0;
}
