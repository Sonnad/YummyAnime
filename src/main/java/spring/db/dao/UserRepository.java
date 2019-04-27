package spring.db.dao;

import org.springframework.data.repository.CrudRepository;
import spring.db.model.User;

/**
 * Created by Sonad on 29.11.17.
 */
public interface UserRepository extends CrudRepository<User, Integer>  {

    User findByLogin(String login);

}
