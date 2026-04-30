package pe.joedayz.dfc.pedidos.service;

import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.joedayz.dfc.pedidos.client.CatalogClient;
import pe.joedayz.dfc.pedidos.dto.OrderView;
import pe.joedayz.dfc.pedidos.dto.ProductSummary;

@Service
public class OrderService {

  private final CatalogClient catalogClient;

  private final Map<String, OrderRecord> orders =
      Map.of("o-1", new OrderRecord("o-1", "p-1", 2), "o-2", new OrderRecord("o-2", "p-2", 1));

  public OrderService(CatalogClient catalogClient) {
    this.catalogClient = catalogClient;
  }

  public Optional<OrderView> findOrder(String orderId) {
    OrderRecord o = orders.get(orderId);
    if (o == null) {
      return Optional.empty();
    }
    ProductSummary p = catalogClient.fetchProduct(o.productId());
    if (p == null) {
      return Optional.of(
          new OrderView(o.id(), o.productId(), o.quantity(), "(catálogo no disponible)", null));
    }
    return Optional.of(
        new OrderView(o.id(), o.productId(), o.quantity(), p.name(), p.price()));
  }

  private record OrderRecord(String id, String productId, int quantity) {}
}
