package livinglab.CatFaceRecognition.cat.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import livinglab.CatFaceRecognition.base.BaseEntity;
import livinglab.CatFaceRecognition.catpage.entity.CatPage;
import livinglab.CatFaceRecognition.account.entity.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    private boolean neuter;
    private String detectedPlace;

    @Column(nullable = true)
    private Long expectedAge;

    @ManyToOne(targetEntity = Account.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "cat", orphanRemoval = true)
    private List<CatPage> catPages = new ArrayList<>();

    @Builder
    public Cat(String name, Sex sex, boolean neuter, String detectedPlace, Long expectedAge, Account account, List<CatPage> catPages) {
        this.name = name;
        this.sex = sex;
        this.neuter = neuter;
        this.detectedPlace = detectedPlace;
        this.expectedAge = expectedAge;
        this.account = account;
        this.catPages = catPages;
    }
}
