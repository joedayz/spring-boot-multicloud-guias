package pe.joedayz.dfc.dynamo.service;

import static pe.joedayz.dfc.dynamo.bootstrap.TableInitializer.TABLE;

import java.util.Map;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

@Service
public class ItemStore {

  private final DynamoDbClient dynamoDbClient;

  public ItemStore(DynamoDbClient dynamoDbClient) {
    this.dynamoDbClient = dynamoDbClient;
  }

  public void put(String pk, String data) {
    dynamoDbClient.putItem(
        PutItemRequest.builder()
            .tableName(TABLE)
            .item(
                Map.of(
                    "pk", AttributeValue.builder().s(pk).build(),
                    "data", AttributeValue.builder().s(data).build()))
            .build());
  }

  public String get(String pk) {
    var out =
        dynamoDbClient.getItem(
            GetItemRequest.builder()
                .tableName(TABLE)
                .key(Map.of("pk", AttributeValue.builder().s(pk).build()))
                .build());
    if (!out.hasItem() || !out.item().containsKey("data")) {
      return null;
    }
    return out.item().get("data").s();
  }
}
