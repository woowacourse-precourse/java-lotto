package lotto.domain;

public enum ErrorMessage {
    ERROR_NUMBER_COUNT("로또 번호는 6개입니다."),
    ERROR_NUMBER_RANGE("로또 번호는 1부터 45까지입니다."),
    ERROR_NUMBER_DUPLICATE("로또 번호에 중복된 숫자는 없습니다.");

    private static final String errorPrefix = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return errorPrefix + errorMessage;
    }
}
