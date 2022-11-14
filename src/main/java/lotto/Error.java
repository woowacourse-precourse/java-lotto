package lotto;

public enum Error {
    INPUT_NOTHING("[ERROR] 아무것도 입력되지 않았습니다."),
    INPUT_BLANK("[ERROR] 아무것도 입력되지 않았습니다.")
    ;

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
