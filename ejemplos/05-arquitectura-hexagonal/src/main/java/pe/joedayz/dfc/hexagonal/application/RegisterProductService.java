package pe.joedayz.dfc.hexagonal.application;

import org.springframework.stereotype.Service;
import pe.joedayz.dfc.hexagonal.domain.model.Product;
import pe.joedayz.dfc.hexagonal.domain.port.ProductRepository;

@Service
public class RegisterProductService {

  private final ProductRepository productRepository;

  public RegisterProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product register(String name) {
    return productRepository.save(Product.newProduct(name));
  }
}
