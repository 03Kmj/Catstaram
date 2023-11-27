package livinglab.CatFaceRecognition.security.details;

import livinglab.CatFaceRecognition.account.entity.Account;
import livinglab.CatFaceRecognition.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final AccountRepository accountRepository;
    /*
    이부분은 String username이 login할 때 id로 입력받는 String인데, 이렇다면 굳이 account entity에
    loginId 필드를 설정할 필요가 없음. email 인증 없이 하려면 어떻게 해야하는지 구현. 그냥 email 추가
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("계정을 찾을 수 없습니다."));

        return new PrincipalDetails(account);
    }
}