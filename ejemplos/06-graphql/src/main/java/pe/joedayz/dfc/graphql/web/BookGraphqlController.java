package pe.joedayz.dfc.graphql.web;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pe.joedayz.dfc.graphql.domain.Book;
import pe.joedayz.dfc.graphql.service.BookService;

@Controller
public class BookGraphqlController {

  private final BookService bookService;

  public BookGraphqlController(BookService bookService) {
    this.bookService = bookService;
  }

  @QueryMapping
  public List<Book> books() {
    return bookService.findAll();
  }

  @QueryMapping
  public Book book(@Argument String id) {
    return bookService.findById(id).orElse(null);
  }
}
