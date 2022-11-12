package lotto.ui.text;

public enum ErrorText {
    INVALID_SIZE("[ERROR] List 크기는 6이여야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 1 ~ 45 범위여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 수는 없어야 합니다."),

    NOT_NUMBER("[ERROR] 입력된 값이 숫자가 아닙니다."),
    ;

    private final String text;

    ErrorText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
