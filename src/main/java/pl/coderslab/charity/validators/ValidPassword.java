package pl.coderslab.charity.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Haslo musi mieć minimum 8 znaków w tym co namniej jedna mala liter, jedna wielka, jedna cyfra oraz jeden znak specjalny";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
