package pe.joedayz.dfc.persistencia.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.persistencia.dto.ItemView;
import pe.joedayz.dfc.persistencia.service.ItemQueryService;
import pe.joedayz.dfc.persistencia.service.StockService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

  private final ItemQueryService itemQueryService;
  private final StockService stockService;

  public ItemController(ItemQueryService itemQueryService, StockService stockService) {
    this.itemQueryService = itemQueryService;
    this.stockService = stockService;
  }

  @GetMapping("/{code}")
  public ItemView get(@PathVariable String code) {
    return itemQueryService.findByCodeOrThrow(code);
  }

  @PostMapping("/{code}/stock")
  @ResponseStatus(HttpStatus.OK)
  public ItemView adjust(@PathVariable String code, @RequestParam int delta) {
    return stockService.adjustStock(code, delta);
  }
}
