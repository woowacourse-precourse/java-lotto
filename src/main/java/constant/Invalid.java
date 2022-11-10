package constant;

public enum Invalid {
    NULL("입력값은 null일 수 없습니다."),
    NOT_INT("입력값이 정수가 아닙니다."),
    OVER_INT_MAX("입력 금액이 INT로 표현할 수 있는 최대값을 넘었습니다."),
    NOT_DIVISIBLE(Amount.UNIT + "로 나눌 수 없습니다."),
    NOT_LOTTO_FORM("입력값을 로또 형태로 전환할 수 없습니다."),
    DUPLICATE_LOTTO("중복된 값이 있습니다."),
    DUPLICATE_BONUS("보너스 번호가 당첨 번호와 중복되었습니다."),
    ;

    final String content;

    Invalid(String content) {
        this.content = content;
    }

    public void throwException() {
        throw new IllegalArgumentException("[ERROR] " + this);
    }

    @Override
    public String toString() {
        return this.content;
    }
}
