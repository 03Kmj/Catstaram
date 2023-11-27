package livinglab.CatFaceRecognition.account.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    private String password;

    @Email
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cat> cats= new ArrayList<>();


    @Builder
    public Account(String password, Role role,String email, List<Cat> cats)
    {
        this.email = email;
        this.role = role;
        this.password = password;
        this.cats = cats;
    }

}
