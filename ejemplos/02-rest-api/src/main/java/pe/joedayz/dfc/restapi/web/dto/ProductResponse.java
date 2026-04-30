package pe.joedayz.dfc.restapi.web.dto;

import java.math.BigDecimal;
import pe.joedayz.dfc.restapi.domain.Product;

public record ProductResponse(Long id, String name, BigDecimal price, String sku) {

  public static ProductResponse from(Product p) {
    return new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getSku());
  }
}
