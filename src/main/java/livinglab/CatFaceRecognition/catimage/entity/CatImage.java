package livinglab.CatFaceRecognition.catimage.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CatImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catimage_id")
    private Long id;

    @Column(nullable = false)
    private String originImageName;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "catpage_id")
    private  CatImage catImage;

    @Builder
    public CatImage(Long id, String originImageName, String imageName, String imagePath) {
        this.id = id;
        this.originImageName = originImageName;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }
}
