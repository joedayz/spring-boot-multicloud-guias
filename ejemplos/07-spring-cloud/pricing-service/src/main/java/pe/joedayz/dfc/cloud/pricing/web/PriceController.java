package pe.joedayz.dfc.cloud.pricing.web;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public class PriceController {

  @Value("${dfc.demo.label:local}")
  private String configLabel;

  @GetMapping("/{sku}")
  public PriceResponse price(
      @PathVariable String sku, @RequestParam(defaultValue = "false") boolean fail) {
    if (fail) {
      throw new IllegalStateException("Fallo simulado para probar el circuit breaker");
    }
    return new PriceResponse(sku, new BigDecimal("19.99"), configLabel);
  }

  public record PriceResponse(String sku, BigDecimal amount, String configSource) {}
}
