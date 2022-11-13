package lotto.Input;

public enum PrintError {
    OVERLAP("[ERROR] 중복된 숫자입니다."),
    OUT_OF_NUMBER_RANGE("[ERROR] 1~45의 범위를 벗어난 숫자입니다."),
    NO_SIX_NUM("[ERROR] 6개의 숫자를 입력하지 않았습니다."),
    NO_ONE_NUM("[ERROR] 1개의 숫자를 입력하지 않았습니다."),
    NO_COMMA("[ERROR] <,>를 사용하지 않았습니다."),
    OUT_OF_MONEY_UNIT("[ERROR] 1000원 단위가 아닙니다.");

    private final String message;

    PrintError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return  message;
    }
}
