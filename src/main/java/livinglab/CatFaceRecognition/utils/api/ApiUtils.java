package livinglab.CatFaceRecognition.utils.api;

public class ApiUtils {
    public static <T> ApiSuccessResult<T> success(T response) {return new ApiSuccessResult<>(response);}

    public static <T> ApiErrorResult<T> error(int code, T message) {
        return new ApiErrorResult<>(code, message);
    }


    public static class ApiSuccessResult<T> {
        private final T response;

        private ApiSuccessResult(T response) {this.response = response;}

        public T getResponse() { return response;}
    }

    public static class ApiErrorResult<T> {
        private final int code;
        private final T message;

        private ApiErrorResult(int code, T message) { this.code =code; this.message = message;}

        public int getCode() { return code;}
        public T getMessage() { return message;}
    }
}
