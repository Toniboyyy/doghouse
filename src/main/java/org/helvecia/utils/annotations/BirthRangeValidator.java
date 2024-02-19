package org.helvecia.utils.annotations;

import java.time.LocalDate;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BirthRangeValidator implements ConstraintValidator<BirthRange, LocalDate> {

    private int min;
    private int max;

    public void initialize(BirthRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        var now = LocalDate.now();
        int age = now.getYear() - value.getYear();

        if(now.isBefore(value) || min >= age && age >= max){
            context.unwrap(HibernateConstraintValidatorContext.class)
                    .addMessageParameter("min", min)
                    .addExpressionVariable("max", max);
            return false;
        }

        return true;
    }
    
}
