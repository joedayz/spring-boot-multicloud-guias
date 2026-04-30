package pe.joedayz.dfc.restapi.web.error;

public class ProductNotFoundException extends RuntimeException {

  private final Long productId;

  public ProductNotFoundException(Long productId) {
    super("Producto no encontrado: " + productId);
    this.productId = productId;
  }

  public Long getProductId() {
    return productId;
  }
}
