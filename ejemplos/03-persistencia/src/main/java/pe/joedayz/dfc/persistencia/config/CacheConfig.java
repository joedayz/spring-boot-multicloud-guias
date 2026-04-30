package pe.joedayz.dfc.persistencia.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CacheConfig {

  @Bean
  @Profile("!redis")
  public CacheManager caffeineCacheManager() {
    CaffeineCacheManager mgr = new CaffeineCacheManager("items");
    mgr.setCaffeine(Caffeine.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).maximumSize(500));
    return mgr;
  }
}
