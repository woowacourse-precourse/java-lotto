package util;

public enum ErrorMessage {
    INSERT_COIN("올바른 금액을 투입해 주세요 (지폐만 가능)"),
    DUPLICATE_NUMBER("중복된 숫자는 잘못된 입력값입니다. 다시 입력해주세요"),
    WINNING_NUMBER_COUNT_ERROR("당첨번호 숫자는 6개를 입력해주세요."),
    BONUS_NUMBER_COUNT_ERROR("보너스 번호는 1개만 입력해주세요."),
    RANGE_ERROR("로또 숫자 범위를 벗어난 숫자입니다. 다시 입력해주세요."),
    NUMERIC_ERROR("숫자만 입력해주세요.");

    private final String errorMessage;
    private static final String startErrorMessage = "[ERROR] ";


    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return startErrorMessage + this.errorMessage;
    }
}
