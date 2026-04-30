package pe.joedayz.dfc.dynamo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.joedayz.dfc.dynamo.service.ItemStore;

@RestController
@RequestMapping("/api/items")
public class ItemController {

  private final ItemStore itemStore;

  public ItemController(ItemStore itemStore) {
    this.itemStore = itemStore;
  }

  @PutMapping("/{pk}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void put(@PathVariable String pk, @RequestBody String body) {
    itemStore.put(pk, body);
  }

  @GetMapping("/{pk}")
  public String get(@PathVariable String pk) {
    String v = itemStore.get(pk);
    if (v == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return v;
  }
}
