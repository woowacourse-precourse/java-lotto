package domain;

public enum ErrorMessage {
    NOT_UNIT("[ERROR] 1000단위로 입력해야합니다."),
    HAVE_DUPLICATION("[ERROR] 중복된 숫자가 있습니다."),
    NOT_RANGE("[ERROR] 숫자의 범위가 1~ 45가 아닙니다"),
    NOT_SIZE("[ERROR] 배열의 길이가 조건보다 더 큽니다."),
    NOT_COMMA("[ERROR] 쉼표로 구분해야합니다");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
