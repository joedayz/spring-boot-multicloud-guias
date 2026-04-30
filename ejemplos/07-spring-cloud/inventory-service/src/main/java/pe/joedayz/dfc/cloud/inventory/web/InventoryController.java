package pe.joedayz.dfc.cloud.inventory.web;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.cloud.inventory.client.PricingGateway;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

  private final PricingGateway pricingGateway;

  public InventoryController(PricingGateway pricingGateway) {
    this.pricingGateway = pricingGateway;
  }

  /**
   * @param failForward si true, pricing recibe fail=true y lanza error (para abrir el circuit breaker
   *     tras varios intentos)
   */
  @GetMapping("/{sku}")
  public InventoryLine get(
      @PathVariable String sku, @RequestParam(defaultValue = "false") boolean failForward) {
    BigDecimal price = pricingGateway.fetchPrice(sku, failForward);
    boolean degraded = price.signum() < 0;
    return new InventoryLine(sku, 100, price, degraded);
  }

  public record InventoryLine(String sku, int quantityOnHand, BigDecimal unitPrice, boolean degradedPricing) {}
}
