package lotto.message;

public enum ErrorMessage {
    RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String errorMessage;
    private final String errorPrefix = "[ERROR] ";

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorPrefix + this.errorMessage;
    }
}
