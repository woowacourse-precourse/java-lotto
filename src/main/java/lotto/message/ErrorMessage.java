package lotto.message;

public enum ErrorMessage {

    ERROR("[ERROR] "),

    MONEY_TYPE_ERROR(ERROR.getErrorMessage() + "돈은 숫자만 입력해야 됩니다."),

    MONEY_UNIT_ERROR(ERROR.getErrorMessage() + "돈은 1000원 단위로 입력해야 됩니다.")

    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
