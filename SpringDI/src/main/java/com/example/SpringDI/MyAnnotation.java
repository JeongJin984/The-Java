package com.example.SpringDI;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {
    String name() default "NJJ";
    int value() default 100;
}
