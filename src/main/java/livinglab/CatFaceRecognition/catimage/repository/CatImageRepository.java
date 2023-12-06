package livinglab.CatFaceRecognition.catimage.repository;

import livinglab.CatFaceRecognition.catimage.entity.CatImage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CatImageRepository extends JpaRepository<CatImage,Long> {
}
