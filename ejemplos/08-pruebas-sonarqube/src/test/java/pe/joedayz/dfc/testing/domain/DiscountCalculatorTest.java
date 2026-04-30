package pe.joedayz.dfc.testing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiscountCalculatorTest {

  static Stream<Arguments> cases() {
    return Stream.of(
        Arguments.of(new BigDecimal("100.00"), 10, new BigDecimal("90.00")),
        Arguments.of(new BigDecimal("50.00"), 0, new BigDecimal("50.00")),
        Arguments.of(new BigDecimal("200.00"), 100, new BigDecimal("0.00")));
  }

  @ParameterizedTest
  @MethodSource("cases")
  void appliesPercent(BigDecimal price, int percent, BigDecimal expected) {
    assertThat(DiscountCalculator.priceAfterPercentDiscount(price, percent)).isEqualByComparingTo(expected);
  }

  @Test
  void rejectsInvalidPercent() {
    assertThatThrownBy(() -> DiscountCalculator.priceAfterPercentDiscount(BigDecimal.TEN, -1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
