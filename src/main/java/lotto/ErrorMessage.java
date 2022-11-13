package lotto;

public enum ErrorMessage {
    TYPE_ERROR("숫자를 입력해야 합니다."),
    VALUE_ERROR("로또 구입 금액은 1000 단위여야 합니다."),
    COMMA_ERROR("쉼표로 구분된 값을 입력해야 합니다."),
    RANGE_ERROR("1~45 의 숫자를 입력해야 합니다."),
    DUPLICATE_ERROR("중복되지 않은 수를 입력해야 합니다."),
    SIZE_ERROR("6개의 숫자를 입력해야 합니다.");

    final private String errorLog;

    public String getErrorLog() {
        String message = "[ERROR] " + this.errorLog;
        return message;
    }

    private ErrorMessage(String errorLog) {
        this.errorLog = errorLog;
    }

}
