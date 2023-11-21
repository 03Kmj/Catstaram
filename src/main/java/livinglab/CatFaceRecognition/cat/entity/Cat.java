package livinglab.CatFaceRecognition.cat.entity;

import jakarta.persistence.*;
import livinglab.CatFaceRecognition.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    private boolean neuter;
    private String detectedPlace;
    private Long expectedAge;

    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    private User user;
}
