package livinglab.CatFaceRecognition.cat.repository;

import livinglab.CatFaceRecognition.cat.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat,Long> {

}
