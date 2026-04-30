package pe.joedayz.dfc.hexagonal.adapter.out.persistence;

import org.springframework.stereotype.Component;
import pe.joedayz.dfc.hexagonal.domain.model.Product;
import pe.joedayz.dfc.hexagonal.domain.port.ProductRepository;

@Component
class ProductRepositoryAdapter implements ProductRepository {

  private final ProductJpaRepository jpa;

  ProductRepositoryAdapter(ProductJpaRepository jpa) {
    this.jpa = jpa;
  }

  @Override
  public Product save(Product product) {
    ProductJpaEntity row = new ProductJpaEntity(product.getName());
    ProductJpaEntity saved = jpa.save(row);
    return product.withId(saved.getId());
  }
}
