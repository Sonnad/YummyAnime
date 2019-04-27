package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.db.dao.*;
import spring.db.model.*;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Iterable<Title> listAll() {
        return titleRepository.findAll();
    }

    @Override
    public Iterable<Comment> listComments(int id) {
        return  commentRepository.findByTitle(titleRepository.findById(id));
    }
}
