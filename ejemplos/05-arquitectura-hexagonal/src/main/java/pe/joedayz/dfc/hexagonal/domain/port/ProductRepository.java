package pe.joedayz.dfc.hexagonal.domain.port;

import pe.joedayz.dfc.hexagonal.domain.model.Product;

/** Puerto de salida: persistencia (implementado por un adaptador JPA). */
public interface ProductRepository {

  Product save(Product product);
}
