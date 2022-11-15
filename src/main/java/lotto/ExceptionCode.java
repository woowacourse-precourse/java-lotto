package lotto;

public enum ExceptionCode {
    INPUT_ERROR("[ERROR] 숫자를 입력해주세요."),
    INPUT_INVALID("[ERROR] 천원 단위로 구매할 수 있습니다."),
    WINNING_ERROR("[ERROR] 올바른 형식이 아닙니다."),
    WINNING_INVALID("[ERROR] 6개의 숫자를 입력해주세요.");
    private final String message;
    ExceptionCode(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
