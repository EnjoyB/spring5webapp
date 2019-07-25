package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Daniel Šulik on 25-Jul-19
 * <p>
 * Class PublisherRepository is used for .....
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
