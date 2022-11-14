package common.message;

public enum ErrorMessage {

    EXCEPTION_START("[ERROR] "),
    EXCEPTION_ONLY_NUMERIC("숫자만 입력해야 합니다."),
    EXCEPTION_NOT_UNIT("1,000원 단위로 입력해야 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
