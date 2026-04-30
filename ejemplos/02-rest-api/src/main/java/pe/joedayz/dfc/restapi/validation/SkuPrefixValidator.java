package pe.joedayz.dfc.restapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SkuPrefixValidator implements ConstraintValidator<SkuPrefix, String> {

  private String prefix;

  @Override
  public void initialize(SkuPrefix constraintAnnotation) {
    this.prefix = constraintAnnotation.value();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.isBlank()) {
      return true;
    }
    return value.startsWith(prefix);
  }
}
