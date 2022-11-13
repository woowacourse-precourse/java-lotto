package lotto.mvc.util.exception;

public class NotFoundViewMessageException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "[ERROR] View 출력 메세지를 찾을 수 없습니다.";

    public NotFoundViewMessageException() {
        super(DEFAULT_MESSAGE);
    }
}
