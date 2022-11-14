package lotto.utils;

public enum Error {
    INVALID_LOTTO_SIZE("로또 번호의 개수가 6개가 아닙니다."),
    INCLUDE_DUPLICATE_VALUE("로또 번호에 중복 번호가 있습니다."),
    IS_NOT_NUMERIC("입력 값에 숫자가 아닌 값이 있습니다"),
    INVALID_BUY_MONEY("구입 금액이 1000보다 작거나 1000으로 나뉘지 않습니다."),
    INVALID_LOTTO_RANGE("로또 번호가 1보다 작거나 45보다 큽니다."),
    INVALID_BONUS_SIZE("보너스 번호의 개수가 1개가 아닙니다."),
    ALREADY_EXIST_WIN_NUMBER("당첨 번호에 이미 중복 값이 존재합니다.");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "[ERROR] " + this.errorMessage;
    }
}
