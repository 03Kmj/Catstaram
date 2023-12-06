package livinglab.CatFaceRecognition.follow.entity;

import jakarta.persistence.*;
import livinglab.CatFaceRecognition.account.entity.Account;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Account.class)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Cat.class)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @Builder
    public Follow( Account account, Cat cat) {
        this.account = account;
        this.cat = cat;
    }
}
