package livinglab.CatFaceRecognition.follow.service;

import livinglab.CatFaceRecognition.account.entity.Account;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import livinglab.CatFaceRecognition.follow.entity.Follow;
import livinglab.CatFaceRecognition.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FollowService {
    private final FollowRepository followRepository;

    public void follow(Account account, Cat cat) {
        Follow follow = Follow.builder()
                .account(account)
                .cat(cat)
                .build();

        followRepository.save(follow);
    }

    public void unfollow(Account account, Cat cat) {
        Follow follow = followRepository.findByAccountAndCat(account,cat);
        if (follow != null) {
            followRepository.delete(follow);
        }
    }

    List<Cat> getFollowedCatByAccount(Account account) {
        List<Follow> follows = followRepository.findByAccount(account);
        return follows.stream()
                .map(Follow::getCat)
                .collect(Collectors.toList());
    }

}
