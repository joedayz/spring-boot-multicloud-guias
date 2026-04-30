package pe.joedayz.dfc.fundamentos.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.fundamentos.config.DevOnlyGreeter;

@RestController
@RequestMapping("/api")
@Profile("dev")
public class DevGreetingController {

  private final DevOnlyGreeter greeter;

  public DevGreetingController(DevOnlyGreeter greeter) {
    this.greeter = greeter;
  }

  @GetMapping("/dev-greeting")
  public Map<String, String> devGreeting() {
    Map<String, String> body = new LinkedHashMap<>();
    body.put("fromProfileDev", greeter.greet());
    return body;
  }
}
