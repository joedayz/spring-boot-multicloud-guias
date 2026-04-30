package pe.joedayz.dfc.testing.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.testing.service.GreetingService;

@RestController
public class HelloController {

  private final GreetingService greetingService;

  public HelloController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @GetMapping("/api/hello")
  public String hello(@RequestParam(required = false) String name) {
    return greetingService.greet(name);
  }
}
