package lotto.utils;

public enum ExceptionType {

    LOWER_THAN_LOTTO_PRICE("[ERROR] 입력한 금액이 1000원보다 작습니다."),
    NOT_DIVISION_INTO_LOTTO_PRICE("[ERROR] 입력한 금액이 1000원으로 나누어 떨어지지 않습니다."),
    IS_NOT_NUMBER("[ERROR] 입력한 값이 숫자가 아닙니다."),
    NOT_WITHIN_THE_RANGE("[ERROR] 올바른 범위의 숫자가 아닙니다."),
    HAVE_OVERLAP("[ERROR] 입력한 값 중 중복되는 값이 존재합니다."),
    OVER_THAN_NUMBER_OF_LOTTO("[ERROR] 입력하신 숫자의 개수가 6개가 아닙니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
