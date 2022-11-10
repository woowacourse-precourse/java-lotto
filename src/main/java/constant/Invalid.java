package constant;

public enum Invalid {
    NULL("입력값은 null일 수 없습니다."),
    NOT_INT("입력값이 정수가 아닙니다."),
    CAN_NOT_BE_DIVIDED(Amount.UNIT + "로 나눌 수 없습니다."),
    OVER_MATCH_ALL_AMOUNT("입력 금액은 1등 당첨금보다 높게 설정할 수 없습니다."),
    NOT_LOTTO_FORM("입력값을 로또 형태로 전환할 수 없습니다."),
    DUPLICATE_LOTTO("중복된 값이 있습니다."),
    DUPLICATE_BONUS("보너스 번호가 당첨 번호와 중복되었습니다."),
    ;

    final String content;

    Invalid(String content) {
        this.content = content;
    }

    public void throwException() {
        throw new IllegalArgumentException("[ERROR] " + this.content);
    }
}
