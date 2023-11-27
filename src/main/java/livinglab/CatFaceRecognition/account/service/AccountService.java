package livinglab.CatFaceRecognition.account.service;

import livinglab.CatFaceRecognition.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    public boolean isExistedByEmail(String email) {
        return accountRepository.existByEmail(email);
    }
}
