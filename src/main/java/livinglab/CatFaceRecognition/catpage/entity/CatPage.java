package livinglab.CatFaceRecognition.catpage.entity;

import jakarta.persistence.*;
import livinglab.CatFaceRecognition.base.BaseEntity;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import livinglab.CatFaceRecognition.catimage.entity.CatImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "catpage")
public class CatPage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catpage_id")
    private Long id;

    private String title;
    private String content;



    @ManyToOne(targetEntity = Cat.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catpage")
    private List<CatImage> catImages = new ArrayList<>();

    @Builder
    public CatPage(String title, String content, Cat cat, List<CatImage> catImages) {
        this.title = title;
        this.content = content;
        this.cat = cat;
        this.catImages = catImages;
    }
}
