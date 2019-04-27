package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.db.dao.*;
import spring.db.model.Genre;
import spring.db.model.Title;
import spring.db.model.User;
import spring.db.model.Voice;

@Service
public class AdmineServiceImpl implements AdminService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private VoiceRepository voiceRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Override
    public Iterable<Genre> listAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public Iterable<Voice> listAllVoice() {
        return voiceRepository.findAll();
    }

    @Override
    public Title addTitle(String animeName, String pictureLink, String videoLink, String translator, Integer year, String genre, String voice, String description) {
        Genre addGenre = genreRepository.findByName(genre);
        Voice addVoice = voiceRepository.findByName(voice);
        pictureLink = "https://s3.eu-west-3.amazonaws.com/sonad395vids/" + pictureLink;
        videoLink = "https://s3.eu-west-3.amazonaws.com/sonad395vids/" + videoLink;
        Title title = new Title(pictureLink, translator, description, description, animeName, videoLink, year, addVoice, addGenre);
        titleRepository.save(title);
        return null;
    }

    @Override
    public Title addTitle(Integer id, String animeName, String pictureLink, String videoLink, String translator, Integer year, String genre, String voice, String description) {
        Genre addGenre = genreRepository.findByName(genre);
        Voice addVoice = voiceRepository.findByName(voice);
        pictureLink = "https://s3.eu-west-3.amazonaws.com/sonad395vids/" + pictureLink;
        videoLink = "https://s3.eu-west-3.amazonaws.com/sonad395vids/" + videoLink;
        Title title = new Title(id,pictureLink, translator, description, description, animeName, videoLink, year, addVoice, addGenre);
        titleRepository.save(title);
        return null;
    }

    @Override
    public boolean delete(String name) {
        Title title = titleRepository.findByName(name);
        if (title == null) return false;
        titleRepository.delete(title);
        return true;
    }

    @Override
    public Title searchTitle(String name) {
        return  titleRepository.findByName(name);
    }
}
