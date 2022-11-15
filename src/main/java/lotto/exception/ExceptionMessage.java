package lotto.exception;

public enum ExceptionMessage {
    ERROR_MESSAGE_SURFIX("[ERROR] "),
    INPUT_NOT_NUMBER_ERROR("금액은 숫자만 입력 가능합니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("중복된 숫자가 있습니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1~45 사이의 숫자이어야 합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_RANGE("보너스 번호는 1~45 사이의 숫자여야 합니다."),
    WINNING_NUMBER_ERROR("당첨 번호는 숫자만 입력 가능합니다."),
    MONEY_LOWER_BOUND_ERROR("금액은 1000원 이상이어야 합니다."),
    MONEY_DIVIDE_ERROR("금액은 1000원으로 나누어 떨어져야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_SURFIX.message + this.message;
    }
}
