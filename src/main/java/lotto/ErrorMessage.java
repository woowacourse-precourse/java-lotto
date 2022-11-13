package lotto;

public enum ErrorMessage {
    NOT_NUMBER("숫자가 아닙니다."),
    NOT_THOUSAND("1000 단위가 아닙니다."),
    OVERLAP("중복된 값이 있습니다."),
    ALREADY("이미 존재하는 값입니다."),
    OUT_OF_RANGE("범위를 초과하였습니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
