package pe.joedayz.dfc.testing.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Lógica pura, fácil de testear sin Spring. */
public final class DiscountCalculator {

  private DiscountCalculator() {}

  public static BigDecimal priceAfterPercentDiscount(BigDecimal price, int percentOff) {
    if (price == null || price.signum() < 0) {
      throw new IllegalArgumentException("price inválido");
    }
    if (percentOff < 0 || percentOff > 100) {
      throw new IllegalArgumentException("percentOff debe estar entre 0 y 100");
    }
    BigDecimal factor = BigDecimal.ONE.subtract(BigDecimal.valueOf(percentOff).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP));
    return price.multiply(factor).setScale(2, RoundingMode.HALF_UP);
  }
}
