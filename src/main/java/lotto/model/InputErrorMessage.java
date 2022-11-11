package lotto.model;

public enum InputErrorMessage {
    INVALID_DIGITS_COUNT("로또 번호는 6자리여야 합니다."),
    DUPLICATE_NUMBERS("당첨 번호의 숫자가 중복됩니다."),
    OUT_OF_RANGE_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다.");;
    private static final String ERROR_HEADER = "[ERROR] ";
    private final String errorMessage;

    InputErrorMessage(String errorMessage) {
        this.errorMessage = ERROR_HEADER + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
