package pe.joedayz.dfc.restapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.joedayz.dfc.restapi.domain.Product;
import pe.joedayz.dfc.restapi.domain.ProductRepository;
import pe.joedayz.dfc.restapi.web.dto.CreateProductRequest;
import pe.joedayz.dfc.restapi.web.dto.ProductResponse;
import pe.joedayz.dfc.restapi.web.dto.UpdateProductRequest;
import pe.joedayz.dfc.restapi.web.error.ProductNotFoundException;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public List<ProductResponse> findAll() {
    return productRepository.findAll().stream().map(ProductResponse::from).toList();
  }

  @Transactional(readOnly = true)
  public ProductResponse findById(Long id) {
    return productRepository
        .findById(id)
        .map(ProductResponse::from)
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Transactional
  public ProductResponse create(CreateProductRequest request) {
    Product p = new Product(request.name(), request.price(), request.sku());
    return ProductResponse.from(productRepository.save(p));
  }

  @Transactional
  public ProductResponse update(Long id, UpdateProductRequest request) {
    Product p =
        productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    p.setName(request.name());
    p.setPrice(request.price());
    return ProductResponse.from(p);
  }

  @Transactional
  public void delete(Long id) {
    if (!productRepository.existsById(id)) {
      throw new ProductNotFoundException(id);
    }
    productRepository.deleteById(id);
  }
}
