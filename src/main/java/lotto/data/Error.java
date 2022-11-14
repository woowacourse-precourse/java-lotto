package lotto.data;

public enum Error {
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    INVALID_SIZE("로또 번호는 6개이어야 합니다."),
    NOT_DIVISIBLE_BY_THOUSAND("금액은 1,000원으로 나누어 떨어져야 합니다."),
    NOT_NUMERIC("입력값은 숫자이어야 합니다.");

    private final String message;

    Error(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
