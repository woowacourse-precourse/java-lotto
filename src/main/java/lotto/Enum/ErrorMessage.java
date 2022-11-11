package lotto.Enum;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    OUT_OF_LENGTH("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBERS("숫자는 중복될 수 없습니다."),
    NOT_PROPER_PAY_MONEY("1000원 단위로만 입력이 가능합니다."),
    NOT_INPUT_INTEGER_MONEY_VALUE("금액은 숫자만 입력 가능합니다."),
    NOT_INPUT_NUMBER_VALUE("번호는 숫자만 입력 가능합니다.");

    private String message;

    private ErrorMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return this.PREFIX + message;
    }
}
