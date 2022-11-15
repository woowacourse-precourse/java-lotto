package lotto;

public enum Error {
    IS_NOT_CORRECT_NUMBER("로또는 6개의 숫자를 가지고 있어야 합니다."),
    IS_NOT_THOUSAND_UNIT("구매 금액은 1,000원 단위여야 합니다."),
    HAS_DUPLICATE_NUMBER("로또 하나의 번호 6개는 서로 중복되지 않은 숫자여야 합니다."),
    IS_INVALID_INPUT("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    HAS_INVALID_SEPARATOR("로또 번호는 쉼표(,)를 이용해 구분해야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
