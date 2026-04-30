package pe.joedayz.dfc.fundamentos.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.fundamentos.config.HeavyService;

@RestController
@RequestMapping("/api")
public class InfoController {

  private final Environment environment;
  private final HeavyService heavyService;

  @Value("${dfc.app.message:Hola Spring Boot}")
  private String appMessage;

  public InfoController(Environment environment, HeavyService heavyService) {
    this.environment = environment;
    this.heavyService = heavyService;
  }

  @GetMapping("/info")
  public Map<String, Object> info() {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("message", appMessage);
    body.put("activeProfiles", environment.getActiveProfiles());
    body.put("heavyService", heavyService.describe());
    return body;
  }
}
