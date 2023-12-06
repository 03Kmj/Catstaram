package livinglab.CatFaceRecognition.follow.repository;

import livinglab.CatFaceRecognition.account.entity.Account;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import livinglab.CatFaceRecognition.follow.entity.Follow;
import org.hibernate.Cache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow findByAccountAndCat(Account account, Cat cat);
    List<Follow> findByAccount(Account account);
}
