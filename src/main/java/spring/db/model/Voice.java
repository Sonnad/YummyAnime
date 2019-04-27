package spring.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sonad on 18.12.17.
 */
@Entity
@Table(name = "voice")
public class Voice {

    public Voice() {
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


    @Column(name = "voice_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = Title.class, mappedBy = "voice")
    private Set<Voice> voiceSet = new HashSet<>();

    @JsonIgnore
    public Set<Voice> getVoiceSet() {
        return voiceSet;
    }

    public void setVoiceSet(Set<Voice> voiceSet) {
        this.voiceSet = voiceSet;
    }


}
