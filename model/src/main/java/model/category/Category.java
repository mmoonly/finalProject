package model.category;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.AEntity;
import model.composition.Composition;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
public class Category extends AEntity {

    @Column(name = "thread")
    private String thread;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "category")
    private List<Composition> compositions;

    public Category(String thread) {
        this.thread = thread;
    }

    public Category(String thread, Category parent) {
        this.thread = thread;
        this.parent = parent;
    }

    public Category(Integer id, String thread) {
        super.setId(id);
        this.thread = thread;
    }

    public Category(Integer id, String thread, Category parentCategory) {
        super.setId(id);
        this.thread = thread;
        this.parent = parentCategory;
    }
}
