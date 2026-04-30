package pe.joedayz.dfc.fundamentos.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class HeavyService {

  private static final Logger log = LoggerFactory.getLogger(HeavyService.class);

  public HeavyService() {
    log.info("HeavyService: inicialización (solo ocurre en el primer uso por @Lazy)");
  }

  public String describe() {
    return "HeavyService listo";
  }
}
