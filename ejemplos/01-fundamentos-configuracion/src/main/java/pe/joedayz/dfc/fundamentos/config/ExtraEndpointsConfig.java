package pe.joedayz.dfc.fundamentos.config;

import static org.springframework.web.servlet.function.RouterFunctions.route;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class ExtraEndpointsConfig {

  @Bean
  @ConditionalOnProperty(name = "dfc.features.extra-endpoint", havingValue = "true")
  RouterFunction<ServerResponse> extraFeatureRoute() {
    return route()
        .GET("/api/extra-feature", request -> ServerResponse.ok().body("Feature flag: extra-endpoint=ON"))
        .build();
  }
}
