package lotto.error;

public enum ErrorMessage {
    WRONG_LENGTH("로또 번호는 6개의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("로또 번호는 중복되지 않는 숫자들로 구성되어야 합니다."),
    NOT_IN_RANGE_WINNING("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 숫자여야 합니다."),
    IN_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    NOT_IN_RANGE_BONUS("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_POSITIVE_MONEY("구입 금액은 0보다 큰 숫자여야 합니다."),
    WRONG_MONEY_UNIT("구입 금액은 1000원 단위여야 합니다."),
    INVALID_MONEY("구입 금액은 숫자여야 합니다."),
    PARSE_ERROR("당첨 번호는 , 기준으로 구분되어야 합니다."),
    TO_INT_ERROR("당첨 번호는 너무 크지 않거나, 숫자로 구성되어야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
