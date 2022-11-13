package lotto.Exception;

public enum ExceptionType {
    MONEY_TYPE_EXCEPTION("[ERROR] 돈은 정수값이 입력되어야 합니다."),
    MONEY_VALUE_EXCEPTION("[ERROR] 돈은 1,000원 단위로 입력되어야 합니다."),

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}