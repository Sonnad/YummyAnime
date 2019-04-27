package spring.db.dao;

import org.springframework.data.repository.CrudRepository;
import spring.db.model.Genre;

/**
 * Created by Sonad on 29.11.17.
 */
public interface GenreRepository extends CrudRepository<Genre, Long>  {

    Genre findByName(String name);
}
