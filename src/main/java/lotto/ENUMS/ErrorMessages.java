package lotto.ENUMS;

public enum ErrorMessages {
    ERROR_SIGN("[ERROR]"),
    DIVIDE_ERROR("구입 금액이 1000원으로 나누어 떨어지지 않습니다.");
    String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
