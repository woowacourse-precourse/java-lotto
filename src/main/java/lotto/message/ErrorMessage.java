package lotto.message;

public enum ErrorMessage {
    PURCHASE_AMOUNT_NOT_NUMBER("구입 금액은 숫자여야 합니다."),
    PURCHASE_AMOUNT_DIVIDE_1000WON("구입 금액은 1000원으로 나누어 떨어져야합니다."),
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
