package lotto.exception;

public enum LottoError {
    NOT_NUMERIC("금액은 숫자여야 합니다."),
    WRONG_UNIT_OF_WON("금액은 1000원 단위여야 합니다."),
    INVALID_NUMBER_RANGE("숫자는 1 ~ 45 범위여야 합니다."),
    INVALID_NUMBERS_LENGTH("6개의 숫자여야 합니다."),
    DISTINCT_NUMBERS("중복된 숫자가 존재합니다.");

    private final String errorMessage;

    LottoError(String errorMessage) {
        String prefix = "[ERROR] ";
        this.errorMessage = prefix + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
