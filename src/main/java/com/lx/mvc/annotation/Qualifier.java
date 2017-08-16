package com.lx.mvc.annotation;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Qualifier {
	String value() default "";
}
