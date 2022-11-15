package lotto.message;

public enum ErrorMessage {
    OUT_OF_RANGE_MESSAGE("보너스 숫자의 범위가 1 ~ 45 이내가 아닙니다."),
    DUPLICATE_MESSAGE("보너스 숫자와 중복이 되는 숫자가 존재합니다.");

    static final String PREFIX = "[ERROR]";
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s %s", PREFIX, message);
    }
}
