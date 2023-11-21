package livinglab.CatFaceRecognition.user.entity;

import jakarta.persistence.*;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cat> cats= new ArrayList<>();


    @Builder
    public User(Long id, String password, List<Cat> cats)
    {
        this.id = id;
        this.password = password;
        this.cats = cats;
    }

}
