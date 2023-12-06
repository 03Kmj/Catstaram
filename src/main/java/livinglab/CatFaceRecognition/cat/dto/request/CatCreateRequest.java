package livinglab.CatFaceRecognition.cat.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import livinglab.CatFaceRecognition.account.entity.Account;
import livinglab.CatFaceRecognition.cat.entity.Cat;
import livinglab.CatFaceRecognition.cat.entity.Sex;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CatCreateRequest {

    private String name;
    private String detectedPlace;
    private Sex sex;
    private Account account;
    private Long expectedAge;
    private boolean neuter;

    public Cat toEntity(Account account) {
        return Cat.builder()
                .name(this.name)
                .detectedPlace(this.detectedPlace)
                .sex(this.sex)
                .account(account)
                .expectedAge(this.expectedAge)
                .neuter(this.neuter)
                .build();
    }
}
