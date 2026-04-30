package pe.joedayz.dfc.catalog.service;

import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.joedayz.dfc.catalog.domain.ProductSummary;

@Service
public class CatalogService {

  private final Map<String, ProductSummary> db =
      Map.of(
          "p-1", new ProductSummary("p-1", "Curso Spring", 99.0),
          "p-2", new ProductSummary("p-2", "Workshop DFC", 149.0));

  public Optional<ProductSummary> findById(String id) {
    return Optional.ofNullable(db.get(id));
  }
}
