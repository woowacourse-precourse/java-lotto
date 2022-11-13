package lotto.Enum;

public enum ErrorMessage {
    OUT_OF_LENGTH("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBERS("숫자는 중복될 수 없습니다."),
    DUPLICATED_BONUS_NUMBERS("보너스숫자는 당첨번호와 중복될 수 없습니다."),
    NOT_PROPER_WINNING_NUMBER_LENGTH("6개의 당첨번호를 입력해주세요."),
    NOT_PROPER_PAY_MONEY("1000원 단위로만 입력이 가능합니다."),
    NOT_INPUT_INTEGER_VALUE("숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return "[ERROR] " + message;
    }
}
