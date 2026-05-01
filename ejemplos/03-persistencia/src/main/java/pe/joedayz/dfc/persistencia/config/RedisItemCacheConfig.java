package pe.joedayz.dfc.persistencia.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pe.joedayz.dfc.persistencia.dto.ItemView;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
@Profile("redis")
public class RedisItemCacheConfig {

  @Bean
  RedisCacheManagerBuilderCustomizer itemViewRedisCacheCustomizer(ObjectMapper objectMapper) {
    Jackson2JsonRedisSerializer<ItemView> serializer =
        new Jackson2JsonRedisSerializer<>(objectMapper, ItemView.class);
    RedisCacheConfiguration cfg =
        RedisCacheConfiguration.defaultCacheConfig()
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(serializer));
    return builder -> builder.cacheDefaults(cfg);
  }
}
