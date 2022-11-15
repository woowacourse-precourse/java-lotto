package view;

public enum ErrorMessage {
    NOT_UNIT("1000단위로 입력해야합니다."),
    HAVE_DUPLICATION("중복된 숫자가 있습니다."),
    NOT_RANGE("숫자의 범위가 1~ 45가 아닙니다"),
    NOT_SIZE("배열의 길이가 조건보다 더 큽니다."),
    NOT_COMMA("쉼표로 구분해야합니다"),
    NOT_INTEGER("숫자가 아닙니다");

    private final String errorMessage;
    private final String PREFIX = "[ERROR]";

    ErrorMessage(String errorMessage) {
        this.errorMessage = PREFIX + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
