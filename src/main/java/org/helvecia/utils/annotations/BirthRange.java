package org.helvecia.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = BirthRangeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthRange {

    String message() default "Alter muss zwischen ({min} - {max}) Jahren sein";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int min() default 0; // Default minimum date
    int max() default 30; 
}
