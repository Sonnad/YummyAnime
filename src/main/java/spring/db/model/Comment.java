package spring.db.model;

import javax.persistence.*;

/**
 * Created by Sonad on 18.12.17.
 */
@Entity
@Table(name = "comment")
public class Comment {

    public Comment() {
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "title")
    private Title title;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Column(name = "text", length=1024)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String description) {
        this.text = text;
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "users")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
