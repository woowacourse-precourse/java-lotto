package lotto;

public enum GameConstant {
    START("구입금액을 입력해 주세요."),
    TYPE_EXCEPTION("[ERROR] 입력값이 숫자이어야 합니다."),
    DIVISIBLE_EXCEPTION("[ERROR] 구입금액은 1,000원 단위이어야 합니다.");


    private final String value;

    GameConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
