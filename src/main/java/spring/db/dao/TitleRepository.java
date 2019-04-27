package spring.db.dao;

import org.springframework.data.repository.CrudRepository;
import spring.db.model.Title;

/**
 * Created by Sonad on 29.11.17.
 */
public interface TitleRepository extends CrudRepository<Title, Integer>  {

    Title findByName(String name);
    Title findById(Integer id);

}
