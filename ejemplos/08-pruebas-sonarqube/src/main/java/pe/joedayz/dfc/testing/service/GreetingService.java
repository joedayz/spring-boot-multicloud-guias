package pe.joedayz.dfc.testing.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  public String greet(String name) {
    if (name == null || name.isBlank()) {
      return "Hola, invitado";
    }
    return "Hola, " + name.trim();
  }
}
