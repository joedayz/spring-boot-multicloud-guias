package pe.joedayz.dfc.persistencia.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.joedayz.dfc.persistencia.domain.Item;
import pe.joedayz.dfc.persistencia.domain.ItemRepository;

@Configuration
public class DataSeed {

  @Bean
  CommandLineRunner seedItems(ItemRepository repository) {
    return args -> {
      if (repository.count() == 0) {
        repository.save(new Item("SKU-DEMO-1", "Artículo demo", 10));
      }
    };
  }
}
