package pe.joedayz.dfc.fundamentos.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevOnlyGreeter {

  public String greet() {
    return "Perfil dev activo: bean DevOnlyGreeter disponible";
  }
}
