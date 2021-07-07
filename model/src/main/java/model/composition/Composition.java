package model.composition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.AEntity;
import model.category.Category;
import model.comment.Comment;
import model.profile.Profile;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "adverts")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Composition extends AEntity {

    @Column(name = "heading")
    private String heading;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "text")
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @OneToMany(mappedBy = "composition")
    private List<Comment> comments;

}
