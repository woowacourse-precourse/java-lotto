package lotto.user.validation;

public enum ExceptionMessage {
    UNITS("구입 금액은 1000원 단위여야 합니다."),
    NUMBER_RANGE("로또 번호의 숫자 범위는 1~45여야 합니다."),
    WRONG_FORMAT("로또 번호 입력은 숫자와 쉼표(,)으로 입력되어야 합니다.");

    private final String message;
    private static final String ERROR = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
