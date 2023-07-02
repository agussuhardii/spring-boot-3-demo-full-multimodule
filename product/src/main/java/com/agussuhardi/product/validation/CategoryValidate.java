package com.agussuhardi.product.validation;


import com.agussuhardi.product.validation.impl.CategoryValidateImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoryValidateImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryValidate {
    String message() default "Category not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
