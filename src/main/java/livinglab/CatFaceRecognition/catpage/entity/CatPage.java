package livinglab.CatFaceRecognition.catpage.entity;

import jakarta.persistence.*;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import livinglab.CatFaceRecognition.catimage.entity.CatImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CatPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catpage_id")
    private Long id;

    private String title;
    private String content;
    private ZonedDateTime zonedDateTime;

    @ManyToOne(targetEntity = Cat.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catpage")
    private List<CatImage> catImages = new ArrayList<>();

    @Builder
    public CatPage(Long id, String title, String content, ZonedDateTime zonedDateTime, Cat cat, List<CatImage> catImages) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.zonedDateTime = zonedDateTime;
        this.cat = cat;
        this.catImages = catImages;
    }
}
