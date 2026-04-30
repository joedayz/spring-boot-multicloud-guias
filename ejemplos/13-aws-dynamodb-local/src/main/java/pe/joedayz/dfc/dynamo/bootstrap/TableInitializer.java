package pe.joedayz.dfc.dynamo.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.BillingMode;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;

@Component
@ConditionalOnProperty(name = "aws.dynamodb.endpoint")
public class TableInitializer {

  private static final Logger log = LoggerFactory.getLogger(TableInitializer.class);

  public static final String TABLE = "dfc_items";

  private final DynamoDbClient dynamoDbClient;

  public TableInitializer(DynamoDbClient dynamoDbClient) {
    this.dynamoDbClient = dynamoDbClient;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void ensureTable() {
    try {
      dynamoDbClient.describeTable(DescribeTableRequest.builder().tableName(TABLE).build());
      log.info("Tabla DynamoDB '{}' ya existe", TABLE);
      return;
    } catch (ResourceNotFoundException ignored) {
      // crear
    }
    dynamoDbClient.createTable(
        CreateTableRequest.builder()
            .tableName(TABLE)
            .billingMode(BillingMode.PAY_PER_REQUEST)
            .keySchema(KeySchemaElement.builder().attributeName("pk").keyType(KeyType.HASH).build())
            .attributeDefinitions(
                AttributeDefinition.builder()
                    .attributeName("pk")
                    .attributeType(ScalarAttributeType.S)
                    .build())
            .build());
    dynamoDbClient.waiter().waitUntilTableExists(b -> b.tableName(TABLE));
    log.info("Tabla '{}' creada", TABLE);
  }
}
