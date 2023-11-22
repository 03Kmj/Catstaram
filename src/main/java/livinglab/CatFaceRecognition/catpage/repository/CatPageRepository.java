package livinglab.CatFaceRecognition.catpage.repository;

import livinglab.CatFaceRecognition.catpage.entity.CatPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatPageRepository extends JpaRepository<CatPage, Long> {
}
