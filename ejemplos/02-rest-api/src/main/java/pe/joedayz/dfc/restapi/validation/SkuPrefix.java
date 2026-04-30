package pe.joedayz.dfc.restapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = SkuPrefixValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SkuPrefix {

  String message() default "El SKU debe comenzar con el prefijo indicado";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String value() default "SKU-";
}
