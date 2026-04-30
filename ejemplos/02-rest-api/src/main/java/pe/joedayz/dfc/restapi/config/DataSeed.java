package pe.joedayz.dfc.restapi.config;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.joedayz.dfc.restapi.domain.Product;
import pe.joedayz.dfc.restapi.domain.ProductRepository;

@Configuration
public class DataSeed {

  @Bean
  CommandLineRunner seedProducts(ProductRepository repository) {
    return args -> {
      if (repository.count() == 0) {
        repository.save(new Product("Libro DFC", new BigDecimal("29.90"), "SKU-BOOK-001"));
        repository.save(new Product("Curso Spring", new BigDecimal("99.00"), "SKU-COURSE-001"));
      }
    };
  }
}
