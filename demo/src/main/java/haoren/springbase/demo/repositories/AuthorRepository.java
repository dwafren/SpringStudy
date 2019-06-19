package haoren.springbase.demo.repositories;

import haoren.springbase.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
