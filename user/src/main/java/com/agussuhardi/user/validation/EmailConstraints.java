package com.agussuhardi.user.validation;



import com.agussuhardi.user.validation.impl.EmailConstraintsImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailConstraintsImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraints {
    String message() default "Already email address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
