package model.comment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.AEntity;
import model.composition.Composition;
import model.profile.Profile;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Comment extends AEntity {

    @Column(name = "value")
    private String value;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "composition_id", nullable = false)
    private Composition composition;

    public Comment(String value, LocalDate now, Profile profile, Composition composition) {
        this.value = value;
        this.publicationDate = now;
        this.profile = profile;
        this.composition = composition;
    }

    public Comment(Integer id, String value, LocalDate date, Profile profile, Composition composition) {
        super.setId(id);
        this.value = value;
        this.publicationDate = date;
        this.profile = profile;
        this.composition = composition;
    }
}
