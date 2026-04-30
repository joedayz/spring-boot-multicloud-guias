package pe.joedayz.dfc.cloud.inventory.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PricingGateway {

  private final WebClient webClient;

  public PricingGateway(WebClient.Builder builder, @Value("${pricing.service.base-url}") String baseUrl) {
    this.webClient = builder.baseUrl(baseUrl).build();
  }

  @CircuitBreaker(name = "pricing", fallbackMethod = "fallbackPrice")
  public BigDecimal fetchPrice(String sku, boolean fail) {
    PriceJson body =
        webClient
            .get()
            .uri(
                uriBuilder -> {
                  var ub = uriBuilder.path("/prices/{sku}");
                  if (fail) {
                    ub.queryParam("fail", true);
                  }
                  return ub.build(sku);
                })
            .retrieve()
            .bodyToMono(PriceJson.class)
            .block();
    return body != null ? body.amount() : BigDecimal.ZERO;
  }

  @SuppressWarnings("unused")
  private BigDecimal fallbackPrice(String sku, boolean fail, Throwable t) {
    return BigDecimal.valueOf(-1);
  }

  public record PriceJson(String sku, BigDecimal amount, String configSource) {}
}
