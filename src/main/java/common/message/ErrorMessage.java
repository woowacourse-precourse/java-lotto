package common.message;

public enum ErrorMessage {

    EXCEPTION_START("[ERROR] "),
    EXCEPTION_ONLY_NUMERIC("숫자만 입력해야 합니다."),
    EXCEPTION_NOT_UNIT("1,000원 단위로 입력해야 합니다."),
    EXCEPTION_RANGE("숫자의 범위가 올바르지 않습니다."),
    EXCEPTION_WINNING_DUPLICATE("중복인 번호가 있습니다."),
    EXCEPTION_WINNING_SIX("당첨번호 6개를 입력해야 합니다.");

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
