package pe.joedayz.dfc.persistencia.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.joedayz.dfc.persistencia.domain.Item;
import pe.joedayz.dfc.persistencia.domain.ItemRepository;
import pe.joedayz.dfc.persistencia.dto.ItemView;
import pe.joedayz.dfc.persistencia.web.error.BusinessRuleException;
import pe.joedayz.dfc.persistencia.web.error.NotFoundException;

@Service
public class StockService {

  private final ItemRepository itemRepository;

  public StockService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @Transactional
  @CacheEvict(cacheNames = "items", key = "#code")
  public ItemView adjustStock(String code, int delta) {
    Item item =
        itemRepository.findByCode(code).orElseThrow(() -> new NotFoundException("Item", code));
    int next = item.getStock() + delta;
    if (next < 0) {
      throw new BusinessRuleException("Stock insuficiente para " + code);
    }
    item.setStock(next);
    Item saved = itemRepository.save(item);
    return ItemView.from(saved);
  }
}
