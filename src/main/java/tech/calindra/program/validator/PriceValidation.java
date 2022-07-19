package tech.calindra.program.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import tech.calindra.program.validator.impl.PriceValidator;

@Documented
@Constraint(validatedBy = PriceValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceValidation {

    String message() default "'salePrice' deve ser menor que 'listPrice'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
