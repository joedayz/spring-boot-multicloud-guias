package pe.joedayz.dfc.azureblob.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlobConfig {

  @Bean
  BlobServiceClient blobServiceClient(@Value("${azure.storage.connection-string}") String connectionString) {
    return new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
  }

  @Bean
  BlobContainerClient blobContainerClient(
      BlobServiceClient blobServiceClient, @Value("${azure.storage.container}") String containerName) {
    BlobContainerClient client = blobServiceClient.getBlobContainerClient(containerName);
    if (!client.exists()) {
      client.create();
    }
    return client;
  }
}
