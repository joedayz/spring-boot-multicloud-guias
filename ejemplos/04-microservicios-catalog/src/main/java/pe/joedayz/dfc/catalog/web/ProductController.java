package pe.joedayz.dfc.catalog.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.joedayz.dfc.catalog.domain.ProductSummary;
import pe.joedayz.dfc.catalog.service.CatalogService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final CatalogService catalogService;

  public ProductController(CatalogService catalogService) {
    this.catalogService = catalogService;
  }

  @GetMapping("/{id}")
  public ProductSummary get(@PathVariable String id) {
    return catalogService
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto " + id));
  }
}
