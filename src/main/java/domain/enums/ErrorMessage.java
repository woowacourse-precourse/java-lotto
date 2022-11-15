package domain.enums;

public enum ErrorMessage {
    DATA_TYPE_ERR("[ERROR] 숫자만 입력 가능합니다."),
    PRICE_ERROR_MESSAGE("[ERROR] 구입 금액은 천원 단위로 입력하셔야만 합니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
