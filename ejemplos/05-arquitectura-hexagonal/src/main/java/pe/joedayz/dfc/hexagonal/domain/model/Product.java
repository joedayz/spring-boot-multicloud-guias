package pe.joedayz.dfc.hexagonal.domain.model;

import java.util.Objects;

/** Modelo de dominio sin anotaciones JPA. */
public final class Product {

  private final Long id;
  private final String name;

  public Product(Long id, String name) {
    this.id = id;
    this.name = Objects.requireNonNull(name, "name");
  }

  public static Product newProduct(String name) {
    return new Product(null, name);
  }

  public Product withId(Long newId) {
    return new Product(newId, name);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
