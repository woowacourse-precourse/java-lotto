package lotto.data.type;

public enum ErrorType {

    NUMBER("숫자를 입력해야 합니다."),
    FORMAT("쉼표로 구분지어 입력해야 합니다."),
    RANGE("%d ~ %d 사이의 숫자를 입력해야 합니다.",
            ConstantNumberType.MIN.getValue(),
            ConstantNumberType.MAX.getValue()),
    MONEY("%d원 단위로 입력해야 합니다.",
            ConstantNumberType.COST.getValue()),
    COUNT("갯수가 %d개 이어야 합니다",
            ConstantNumberType.COUNT.getValue()),
    ;

    private static final String ERROR_BASE = "[ERROR] ";

    private final IllegalArgumentException exception;

    ErrorType(String message, Object... replacers) {
        this.exception = new IllegalArgumentException(ERROR_BASE + String.format(message, replacers));
    }

    public IllegalArgumentException getException() {
        return this.exception;
    }
}
