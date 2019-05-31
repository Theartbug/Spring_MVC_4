package com.pluralsight.view;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    // refers to key inside of messages.properties
    String message() default "{Phone}";

    // generic array
    Class<?>[] groups() default {};

    // pass in values associated with annotation
    Class<? extends Payload>[] payload() default{};
}
