package pe.joedayz.dfc.pedidos.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import pe.joedayz.dfc.pedidos.dto.ProductSummary;

@Component
public class CatalogClient {

  private final WebClient webClient;

  public CatalogClient(WebClient.Builder builder, @Value("${dfc.catalog.base-url}") String baseUrl) {
    this.webClient = builder.baseUrl(baseUrl).build();
  }

  public ProductSummary fetchProduct(String productId) {
    try {
      return webClient
          .get()
          .uri("/api/products/{id}", productId)
          .retrieve()
          .bodyToMono(ProductSummary.class)
          .block();
    } catch (WebClientResponseException e) {
      if (e.getStatusCode().value() == 404) {
        return null;
      }
      throw e;
    } catch (WebClientRequestException e) {
      return null;
    }
  }
}
