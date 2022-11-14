package lotto;

public enum Error {
    INPUT_NOTHING("[ERROR] 아무것도 입력되지 않았습니다."),
    INPUT_BLANK("[ERROR] 아무것도 입력되지 않았습니다."),
    INPUT_WITH_BLACK("[ERROR] 빈칸이 입력되었습니다."),
    INPUT_NOT_NUMERIC("[ERROR] 숫자만 입력 가능합니다."),
    LESS_THAN_1000WON("[ERROR] 1000원 이상부터 구매 가능합니다.")
    ;

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
