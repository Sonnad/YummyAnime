package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.db.dao.CommentRepository;
import spring.db.dao.TitleRepository;
import spring.db.dao.UserRepository;
import spring.db.model.Comment;
import spring.db.model.Title;
import spring.db.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(String userName) {
        User user = userRepository.findByLogin(userName);
        if (user == null) return false;
        userRepository.delete(user);
        return true;
    }
}
