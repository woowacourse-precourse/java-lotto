package lotto.exception;

public enum LottoException {
    NUMBER_DUPLICATED("중복된 숫자를 포함할 수 없습니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_COUNT_MISMATCH("6개의 숫자를 입력하세요."),
    NOT_NUMBER("숫자만 입력할 수 있습니다."),
    FORBID_EMPTY("공백을 입력할 수 없습니다."),
    MONEY_ERROR("로또를 구입할 수 없는 금액입니다.");

    private final String errorMessage;

    LottoException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }

}
