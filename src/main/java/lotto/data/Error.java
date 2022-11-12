package lotto.data;

public enum Error {
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    OVER_SIZE("로또 번호는 6개이어야 합니다."),
    INVALID_PRICE("금액은 1,000원으로 나누어 떨어져야 합니다.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
