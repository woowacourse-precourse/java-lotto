package lotto.exception;

public enum ErrorMessage {

    DUPLICATED_NUMBER_MESSAGE("로또 번호는 중복되지 않은 숫자여야 합니다."),
    INVALID_RANGE_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_SIZE_MESSAGE("로또 번호는 6개로 이루어져야 합니다."),
    INVALID_UNIT_MESSAGE("로또 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_INPUT_MESSAGE("올바르지 않은 입력입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
