package spring.service;


import spring.db.model.Genre;
import spring.db.model.Title;
import spring.db.model.User;
import spring.db.model.Voice;

public interface AdminService {

    Iterable<Genre> listAllGenre();

    Iterable<Voice> listAllVoice();

    Title addTitle(String animeName, String pictureLink, String videoLink, String translator, Integer year, String genre, String voice, String description );

    Title addTitle(Integer id, String animeName, String pictureLink, String videoLink, String translator, Integer year, String genre, String voice, String description );

    boolean delete(String name);

    Title searchTitle(String name);

}
