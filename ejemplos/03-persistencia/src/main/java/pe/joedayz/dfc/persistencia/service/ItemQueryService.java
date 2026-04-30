package pe.joedayz.dfc.persistencia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.joedayz.dfc.persistencia.domain.Item;
import pe.joedayz.dfc.persistencia.domain.ItemRepository;
import pe.joedayz.dfc.persistencia.dto.ItemView;
import pe.joedayz.dfc.persistencia.web.error.NotFoundException;

@Service
public class ItemQueryService {

  private static final Logger log = LoggerFactory.getLogger(ItemQueryService.class);

  private final ItemRepository itemRepository;

  public ItemQueryService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @Transactional(readOnly = true)
  @Cacheable(cacheNames = "items", key = "#code")
  public ItemView findByCodeOrThrow(String code) {
    log.info(
        "Cargando item desde BD (si repites GET y no ves este log, la caché está funcionando): {}",
        code);
    Item item = itemRepository.findByCode(code).orElseThrow(() -> new NotFoundException("Item", code));
    return ItemView.from(item);
  }
}
