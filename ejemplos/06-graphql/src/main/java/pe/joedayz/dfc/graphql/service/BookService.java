package pe.joedayz.dfc.graphql.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.joedayz.dfc.graphql.domain.Book;

@Service
public class BookService {

  private final Map<String, Book> books =
      Map.of(
          "1", new Book("1", "Spring in Action", "Craig Walls"),
          "2", new Book("2", "Learning GraphQL", "Eve Porcello"));

  public List<Book> findAll() {
    return List.copyOf(books.values());
  }

  public Optional<Book> findById(String id) {
    return Optional.ofNullable(books.get(id));
  }
}
