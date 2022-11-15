package lotto.constants;

public enum InputExceptionConstants {
    INPUT_NONE_SPLIT("분할될 수 없는 입력입니다."),
    INPUT_NONE_NUMERIC("수가 아닌 입력이 있습니다."),
    INPUT_BLANK("빈 문자열이 입력되었습니다."),
    INPUT_ZERO("0원은 입력받을 수 없습니다."),
    INPUT_REST_EXIST("입력금액과 로또 금액이 나누어 떨어지지 않습니다."),
    ;

    private final String value;

    InputExceptionConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
