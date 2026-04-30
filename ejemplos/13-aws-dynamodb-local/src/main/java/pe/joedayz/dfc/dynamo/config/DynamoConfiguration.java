package pe.joedayz.dfc.dynamo.config;

import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoConfiguration {

  @Bean
  DynamoDbClient dynamoDbClient(@Value("${aws.dynamodb.endpoint:}") String endpoint) {
    var builder = DynamoDbClient.builder().region(Region.of("us-east-1"));
    if (endpoint != null && !endpoint.isBlank()) {
      builder
          .endpointOverride(URI.create(endpoint))
          .credentialsProvider(
              StaticCredentialsProvider.create(AwsBasicCredentials.create("local", "local")));
    } else {
      builder.credentialsProvider(DefaultCredentialsProvider.create());
    }
    return builder.build();
  }
}
