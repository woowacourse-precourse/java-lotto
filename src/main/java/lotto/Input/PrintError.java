package lotto.Input;

public enum PrintError {
    OVERLAP("[ERROR] 중복된 숫자입니다.%n"),
    OUT_OF_RANGE("[ERROR] 1~45의 범위를 벗어난 숫자입니다.%n"),
    OUT_OF_MONEY_UNIT("[ERROR] 1000원 단위가 아닙니다.%n");

    private final String message;

    PrintError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return  message;
    }
}
