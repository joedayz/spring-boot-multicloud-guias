package pe.joedayz.dfc.persistencia.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

  Optional<Item> findByCode(String code);
}
