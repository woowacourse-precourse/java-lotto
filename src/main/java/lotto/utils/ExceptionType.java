package lotto.utils;

public enum ExceptionType {

    LOWER_THAN_1000("[ERROR] 입력한 금액이 1000원보다 작습니다."),
    NOT_DIVISION_INTO_1000("[ERROR] 입력한 금액이 1000원으로 나누어 떨어지지 않습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
