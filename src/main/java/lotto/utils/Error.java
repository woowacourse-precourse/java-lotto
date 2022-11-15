package lotto.utils;

public enum Error {
    NOT_NUMBER("[ERROR] 숫자가 아닌 값을 포함하고 있습니다."),
    DUPLICATED_NUMBER("[ERROR] 중복된 숫자는 포함될 수 없습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 1부터 45 사이의 숫자만 포함되어야 합니다."),
    INPUT_MONEY_CHECK("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");

    Error(String message) {
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
