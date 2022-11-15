package lotto.ENUMS;

public enum ErrorMessages {
    ERROR_SIGN("[ERROR]"),
    DIVIDE_ERROR("구입 금액이 1000원으로 나누어 떨어지지 않습니다."),
    IS_NOT_NUMBER("구입 금액이 숫자로 이뤄져 있지 않습니다."),
    COUNT_ERROR("로또 번호의 개수가 정상적이지 않습니다."),
    DUPLICATE_ERROR("로또 번호에 중복이 있습니다.");
    String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}