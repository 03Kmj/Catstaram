package livinglab.CatFaceRecognition.utils.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import livinglab.CatFaceRecognition.exception.CookieNotFoundException;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    public static final String ACCESS_TOKEN_COOKIE_NAME = "ACCESS_TOKEN_COOKIE";
    private static final int ACCESS_COOKIE_VALIDATION_SECOND = 1000 * 60 * 60 * 30;

    public ResponseCookie createCookie(String value) {
        return ResponseCookie.from(ACCESS_TOKEN_COOKIE_NAME, value)
                .httpOnly(false)
                .path("/")
                .secure(false)
                .maxAge(ACCESS_COOKIE_VALIDATION_SECOND)
                .build();
    }

    public ResponseCookie getCookie(HttpServletRequest request, String name) {
        Cookie[] findCookies = request.getCookies();
        if (findCookies == null) {
            throw new CookieNotFoundException("전달된 쿠키가 없습니다.");
        }
        for (Cookie cookie : findCookies) {
            if (cookie.getName().equals(name)) {
                return ResponseCookie.from(name, cookie.getValue()).build();
            }
        }
        throw new CookieNotFoundException("쿠키를 찾을 수 없습니다.");
    }
}
