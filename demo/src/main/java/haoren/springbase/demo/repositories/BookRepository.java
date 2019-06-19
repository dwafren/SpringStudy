package haoren.springbase.demo.repositories;

import haoren.springbase.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
