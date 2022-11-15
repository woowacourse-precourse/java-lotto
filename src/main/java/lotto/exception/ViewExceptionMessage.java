package lotto.exception;

public enum ViewExceptionMessage {
    INPUT_DIGIT_EXCEPTION("[ERROR] 입력값이 숫자로 인식되지 않아 오류가 발생하였습니다.");

    private final String message;

    ViewExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
