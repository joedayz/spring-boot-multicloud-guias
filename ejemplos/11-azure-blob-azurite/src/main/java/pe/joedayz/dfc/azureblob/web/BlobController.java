package pe.joedayz.dfc.azureblob.web;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import java.nio.charset.StandardCharsets;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blobs")
public class BlobController {

  private final BlobContainerClient containerClient;

  public BlobController(BlobContainerClient containerClient) {
    this.containerClient = containerClient;
  }

  @PutMapping("/{name}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void upload(@PathVariable String name, @RequestBody String body) {
    BlobClient blob = containerClient.getBlobClient(name);
    blob.upload(new java.io.ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)), body.length());
  }

  @GetMapping("/{name}")
  public String download(@PathVariable String name) {
    BlobClient blob = containerClient.getBlobClient(name);
    if (!blob.exists()) {
      throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return blob.downloadContent().toString();
  }
}
