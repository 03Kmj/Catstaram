package livinglab.CatFaceRecognition.cat.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import livinglab.CatFaceRecognition.account.entity.Account;
import livinglab.CatFaceRecognition.cat.entity.Sex;
import livinglab.CatFaceRecognition.catpage.entity.CatPage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CatReadResponse {
    private String name;
    private Sex sex;
    private boolean neuter;
    private String detectedPlace;
    private Long expectedAge;
    private Account account;

}
