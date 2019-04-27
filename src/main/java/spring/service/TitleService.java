package spring.service;


import spring.db.model.Comment;
import spring.db.model.Title;

public interface TitleService {

    Iterable<Title> listAll();
    Iterable<Comment> listComments(int id);


}
