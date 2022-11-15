package lotto;

public enum ExceptionCode {
    INPUT_ERROR("[ERROR] 숫자를 입력해주세요."),
    INPUT_INVALID("[ERROR] 천원 단위로 구매할 수 있습니다."),
    WINNING_ERROR("[ERROR] 올바른 형식이 아닙니다."),
    LENGTH_ERROR("[ERROR] 6개의 숫자를 입력해주세요."),
    NUMBER_RANGE("[ERROR] 1~45 범위의 숫자를 입력해 주세요."),
    DUPLICATION_ERROR("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    private final String message;
    ExceptionCode(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
