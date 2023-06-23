package com.mintifi.companyapi.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.*;
import jakarta.validation.Constraint;


@Documented
@Constraint(validatedBy = AttributeValueValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateAttributeValue {

  String message() default "{AttributeValueValidator.error}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
