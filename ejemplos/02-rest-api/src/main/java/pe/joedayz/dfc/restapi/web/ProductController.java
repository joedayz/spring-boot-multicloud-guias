package pe.joedayz.dfc.restapi.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.restapi.service.ProductService;
import pe.joedayz.dfc.restapi.web.dto.CreateProductRequest;
import pe.joedayz.dfc.restapi.web.dto.ProductResponse;
import pe.joedayz.dfc.restapi.web.dto.UpdateProductRequest;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Productos", description = "CRUD de ejemplo")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  @Operation(summary = "Listar productos")
  public List<ProductResponse> list() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obtener por id")
  public ProductResponse get(@PathVariable Long id) {
    return productService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Crear producto")
  public ProductResponse create(@Valid @RequestBody CreateProductRequest request) {
    return productService.create(request);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Actualizar nombre y precio")
  public ProductResponse update(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest request) {
    return productService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Eliminar")
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }
}
