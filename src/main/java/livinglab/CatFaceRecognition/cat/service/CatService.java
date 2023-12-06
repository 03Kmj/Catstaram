package livinglab.CatFaceRecognition.cat.service;

import livinglab.CatFaceRecognition.account.entity.Account;
import livinglab.CatFaceRecognition.account.repository.AccountRepository;
import livinglab.CatFaceRecognition.cat.dto.request.CatCreateRequest;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import livinglab.CatFaceRecognition.cat.repository.CatRepository;
import livinglab.CatFaceRecognition.teachable.TeachableApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CatService {
    private final AccountRepository accountRepository;
    private final CatRepository catRepository;
    private final TeachableApi teachableApi;

    @Transactional
    public Long createCat(Account account, CatCreateRequest catCreateRequest) {
        //api를 받아서 학습이 안된 고양이면 createCat하고, 그 account에 cat 추가라는 조건 만들어야함.
        Cat cat = catRepository.save(catCreateRequest.toEntity(account));
        return cat.getId();
    }

    public void readCat(String catName) {
        Cat cat = this.findByCatName(catName);
    }

    public Cat findByCatName(String catName) {
        return catRepository.findById(catName)
    }
}
