package lotto.user.validation;

public enum ExceptionMessage {
    UNITS("구입 금액은 1000원 단위여야 합니다."),
    NUMBER_RANGE("숫자 범위는 1~45여야 합니다."),
    WRONG_FORMAT("로또 번호는 숫자와 쉼표(,)으로 입력되어야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복된 숫자가 없어야 합니다."),
    NUMBERS_LENGTH("로또 번호는 6개의 숫자로 구성되어야 합니다."),
    ONLY_NUMBER("오직 숫자만 입력할 수 있습니다.");

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
