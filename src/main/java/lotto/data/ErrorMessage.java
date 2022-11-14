package lotto.data;

public enum ErrorMessage {
    TYPE_ERROR("숫자를 입력해야 합니다."),
    VALUE_ERROR("로또 구입 금액은 1000 단위여야 합니다."),
    COMMA_ERROR("쉼표로 구분된 값을 입력해야 합니다."),
    RANGE_ERROR("1~45 의 숫자를 입력해야 합니다."),
    DUPLICATE_ERROR("중복되지 않은 수를 입력해야 합니다."),
    SIZE_ERROR("6개의 숫자를 입력해야 합니다."),

    RANDOM_SIZE_ERROR("6개의 로또 번호가 생성되지 않았습니다."),
    RANDOM_DUPLICATE_ERROR("중복된 로또 번호가 생성되었습니다.");


    final private String errorLog;

    public String getErrorLog() {
        return "[ERROR] " + this.errorLog;
    }

    ErrorMessage(String errorLog) {
        this.errorLog = errorLog;
    }

}
