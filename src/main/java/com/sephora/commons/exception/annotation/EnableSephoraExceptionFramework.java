package com.sephora.commons.exception.annotation;

import com.sephora.commons.exception.advice.SephoraExceptionAdvice;
import java.lang.annotation.*;
import org.springframework.context.annotation.Import;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SephoraExceptionAdvice.class})
public @interface EnableSephoraExceptionFramework {}
