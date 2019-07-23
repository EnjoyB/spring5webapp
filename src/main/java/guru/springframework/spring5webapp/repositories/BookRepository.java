package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Daniel Šulik on 23-Jul-19
 * <p>
 * Class BookRepository is used for .....
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
