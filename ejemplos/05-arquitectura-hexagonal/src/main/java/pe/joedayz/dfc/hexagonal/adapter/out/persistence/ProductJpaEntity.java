package pe.joedayz.dfc.hexagonal.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hex_products")
class ProductJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  protected ProductJpaEntity() {}

  ProductJpaEntity(String name) {
    this.name = name;
  }

  Long getId() {
    return id;
  }

  String getName() {
    return name;
  }
}
