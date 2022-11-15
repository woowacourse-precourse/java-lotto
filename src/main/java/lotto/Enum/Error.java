package lotto.Enum;

public enum Error {
    SIZE(String.format("로또 번호는 %d개만 가능합니다.", Number.SIZE.getValue())),
    DUPLICATE("로또 번호들은 중복될 수 없습니다."),
    UNIT(String.format("%d 단위 숫자만 입력해주세요.", Number.UNIT.getValue())),
    BELOW(String.format("최소 %d원부터 구매 가능합니다.", Number.UNIT.getValue())),
    NUMBER(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", Number.MIN.getValue(), Number.MAX.getValue())),
    BONUS("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    ;

    private static final String ERROR = "[ERROR] ";

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
