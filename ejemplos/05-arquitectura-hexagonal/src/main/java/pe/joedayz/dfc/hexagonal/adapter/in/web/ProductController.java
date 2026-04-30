package pe.joedayz.dfc.hexagonal.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.hexagonal.application.RegisterProductService;
import pe.joedayz.dfc.hexagonal.domain.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final RegisterProductService registerProductService;

  public ProductController(RegisterProductService registerProductService) {
    this.registerProductService = registerProductService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponse create(@RequestBody CreateRequest body) {
    Product p = registerProductService.register(body.name());
    return new ProductResponse(p.getId(), p.getName());
  }

  public record CreateRequest(String name) {}

  public record ProductResponse(Long id, String name) {}
}
