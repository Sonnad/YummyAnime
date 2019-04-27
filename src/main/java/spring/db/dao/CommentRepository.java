package spring.db.dao;

import org.springframework.data.repository.CrudRepository;
import spring.db.model.Comment;
import spring.db.model.Title;

import java.util.List;

/**
 * Created by Sonad on 29.11.17.
 */
public interface CommentRepository extends CrudRepository<Comment, Integer>  {

    List<Comment> findByTitle(Title title);

}
