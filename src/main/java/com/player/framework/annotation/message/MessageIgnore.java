package com.player.framework.annotation.message;

import java.lang.annotation.*;

/**
 * 忽略类,让其不参与解码,但参与编码
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageIgnore {

}
