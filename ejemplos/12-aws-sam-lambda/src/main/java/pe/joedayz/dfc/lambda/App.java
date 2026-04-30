package pe.joedayz.dfc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * Handler mínimo. Para API Gateway (proxy), el evento suele ser un Map con path, headers, body, etc.
 */
public class App implements RequestHandler<Map<String, Object>, Map<String, Object>> {

  @Override
  public Map<String, Object> handleRequest(Map<String, Object> event, Context context) {
    Map<String, Object> response = new HashMap<>();
    response.put("statusCode", 200);
    response.put("headers", Map.of("Content-Type", "application/json"));
    response.put("body", "{\"message\":\"Hola desde Lambda (DFC / SAM)\"}");
    return response;
  }
}
