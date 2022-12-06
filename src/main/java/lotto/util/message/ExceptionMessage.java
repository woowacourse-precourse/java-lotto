package lotto.util.message;

public enum ExceptionMessage {
    OUT_OF_SCOPE("숫자 범위는 1~45까지입니다."),
    DUPLICATED("중복된 값을 입력할 수 없습니다."),
    WRONG_SIZE("6개의 숫자를 입력해야 합니다."),
    NOT_NUMBER("숫자를 입력해야 합니다."),
    IS_NEGATIVE("음수를 입력할 수 없습니다."),
    WRONG_FORMAT("구입금액은 1,000원 단위로 입력해야 합니다.");

    private final String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
