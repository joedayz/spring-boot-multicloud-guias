package pe.joedayz.dfc.persistencia.dto;

import pe.joedayz.dfc.persistencia.domain.Item;

public record ItemView(String code, String name, int stock) {

  public static ItemView from(Item item) {
    return new ItemView(item.getCode(), item.getName(), item.getStock());
  }
}
