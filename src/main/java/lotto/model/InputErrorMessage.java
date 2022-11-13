package lotto.model;

public enum InputErrorMessage {
    INVALID_DIGITS_COUNT("로또 번호는 6자리여야 합니다."),
    DUPLICATE_NUMBERS("당첨 번호의 숫자가 중복됩니다."),
    OUT_OF_RANGE_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_FORMAT_MONEY("구입 금액은 숫자여야 합니다."),
    MONEY_IS_NOT_DIVIDED("구입 금액은 1000원 단위여야 합니다."),
    INVALID_LOTTO_NUMBERS("당첨 번호는 쉼표로 구분된 숫자로 이루어진 문자열이어야 합니다."),
    BONUS_NUMBER_IS_NOT_NUMBER("보너스 번호는 숫자여야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다.")
    ;
    private static final String ERROR_HEADER = "[ERROR] ";
    private final String errorMessage;

    InputErrorMessage(String errorMessage) {
        this.errorMessage = ERROR_HEADER + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
