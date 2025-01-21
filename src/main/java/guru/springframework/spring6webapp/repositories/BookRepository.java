package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
