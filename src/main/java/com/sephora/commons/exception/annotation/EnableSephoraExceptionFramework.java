package com.sephora.commons.exception.annotation;

import com.sephora.commons.exception.advice.SephoraExceptionAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SephoraExceptionAdvice.class})
public @interface EnableSephoraExceptionFramework {}
