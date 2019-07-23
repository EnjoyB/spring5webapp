package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Daniel Šulik on 23-Jul-19
 * <p>
 * Class AuthorRepository is used for .....
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
