package spring.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sonad on 18.12.17.
 */
@Entity
@Table(name = "Genre")
public class Genre {

    public Genre() {
    }

    public Genre(String name) {

        this.name = name;
    }

    public Genre(Integer id, String name) {
        this.id= id;
        this.name = name;
    }

    @OneToMany(targetEntity = Title.class, mappedBy = "genre")
    private Set<Title> titleSet = new HashSet<>();

    @JsonIgnore
    public Set<Title> getTitleSet() {
        return titleSet;
    }

    public void setTitleSet(Set<Title> titleSet) {
        this.titleSet = titleSet;
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

    @Column(name = "genre_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
