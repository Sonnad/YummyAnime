package spring.service;


import spring.db.model.Comment;
import spring.db.model.Title;
import spring.db.model.User;

public interface UserService {

    Iterable<User> listAll();
    boolean deleteUser(String userName);


}
