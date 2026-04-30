package pe.joedayz.dfc.persistencia.web.error;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String type, String id) {
    super(type + " no encontrado: " + id);
  }
}
