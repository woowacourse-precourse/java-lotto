package lotto.status;

public enum ExceptionStatus {
    ZERO_IN_HEAD("[ERROR] 올바르지 않은 숫자입니다."),
    NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    NOT_DIVIDE_BASE_PRICE("[ERROR] 1000으로 나누어지는 수가 아닙니다."),
    NOT_CORRECT_SHAPE("[ERROR] 올바른 형태가 아닙니다."),

    CONTAIN_ONLY_NUMBER("[ERROR] 숫자가 아닌 다른 값이 포함되어 있습니다."),
    NOT_BOUNDARY_NUMBER("[ERROR] 유효범위가 아닙니다."),
    IS_DUPLICATED("[ERROR] 당첨번호중 중복되는 수가 있습니다.");

    private String text;

    ExceptionStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
