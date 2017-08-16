package com.lx.mvc.annotation;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestHeader {
	String value() default "";
}
