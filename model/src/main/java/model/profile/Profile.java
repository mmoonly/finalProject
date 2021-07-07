package model.profile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.AEntity;
import model.comment.Comment;
import model.composition.Composition;
import model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profiles")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Profile extends AEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy = "profile")
    private List<Composition> compositions;

    @OneToMany(mappedBy = "profile")
    private List<Comment> comments;

    public Profile(String name, String surname, User user) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.rating = 0;
    }

    public Profile(Integer id, String name, String surname, Integer rating) {
        super.setId(id);
        this.name = name;
        this.surname = surname;
        this.rating = rating;
    }

}
