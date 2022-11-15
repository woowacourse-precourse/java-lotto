package lotto.type;

public enum ExceptionType {

    NUMBER("숫자를 입력해야 합니다."),
    FORMAT("쉼표로 구분된 숫자들을 %d개 입력해야 합니다.",
            ConstantNumberType.COUNT.getValue()),
    DUPLICATE("중복되지 않은 숫자를 입력해야 합니다."),
    RANGE("%d ~ %d 사이의 숫자를 입력해야 합니다.",
            ConstantNumberType.MIN.getValue(),
            ConstantNumberType.MAX.getValue()),
    MONEY("%d원 단위로 입력해야 합니다.",
            ConstantNumberType.COST.getValue()),
    COUNT("갯수가 %d개 이어야 합니다",
            ConstantNumberType.COUNT.getValue()),
    EMPTY("적어도 하나의 로또는 구매해야 합니다."),
    NULL("번호를 받지 못했습니다."),
    FINISHED_ROUND("해당 회차는 이미 종료되었습니다."),
    NULL_PURCHASE("해당 유저의 구매 이력이 존재하지 않습니다."),
    NULL_ROUND("해당 회차가 존재하지 않습니다."),
    NULL_WIN_NUMBER("해당 회차의 당첨 번호가 아직 결정되지 않았습니다."),
    ;

    private static final String ERROR_BASE = "[ERROR] ";

    private final IllegalArgumentException exception;

    ExceptionType(String message, Object... replacers) {
        this.exception = new IllegalArgumentException(ERROR_BASE + String.format(message, replacers));
    }

    public IllegalArgumentException getException() {
        return this.exception;
    }
}
