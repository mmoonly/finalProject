package model.user;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.AEntity;
import model.profile.Profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor

public class User extends AEntity {

    @Column(name = "login")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

    @OneToOne(mappedBy = "user")
    private Profile profile;

}