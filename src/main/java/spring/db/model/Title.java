package spring.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sonad on 18.12.17.
 */
@Entity
@Table(name = "title")
public class Title {


    public Title() {
    }

    public Title(String picture, String translator, String shortDescription, String description, String name, String video, Integer year, Voice voice, Genre genre) {
        this.picture = picture;
        this.translator = translator;
        this.shortDescription = shortDescription;
        this.description = description;
        this.name = name;
        this.video = video;
        this.year = year;
        this.voice = voice;
        this.genre = genre;
    }

    public Title(Integer id, String picture, String translator, String shortDescription, String description, String name, String video, Integer year, Voice voice, Genre genre) {
        this.picture = picture;
        this.translator = translator;
        this.shortDescription = shortDescription;
        this.description = description;
        this.name = name;
        this.video = video;
        this.year = year;
        this.voice = voice;
        this.genre = genre;
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "picture")
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name = "translator")
    private String translator;

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    @Column(name = "short_description", length=1024)
    private String shortDescription;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Column(name = "description", length=1024)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "title_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "video")
    private String video;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Column(name = "title_year")
    private Integer year;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "voice")
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "genre")
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @OneToMany(targetEntity = Comment.class, mappedBy = "title", cascade = CascadeType.REMOVE)
    private Set<Comment> commentSet = new HashSet<>();

    @JsonIgnore
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

}
