package lotto;

public enum GameConstant {
    START("구입금액을 입력해 주세요."),
    TYPE_EXCEPTION("[ERROR] 입력값이 숫자이어야 합니다."),
    DIVISIBLE_EXCEPTION("[ERROR] 구입금액은 1,000원 단위이어야 합니다."),
    BOUNDARY_EXCEPTION("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_EXCEPTION("[ERROR] 중복된 숫자가 있습니다."),
    SIZE_EXCEPTION("[ERROR] 6개의 숫자만 허용됩니다."),
    NUMBER_OF_GAME("개를 구매했습니다."),
    GET_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("보너스 번호를 입력해 주세요.");


    private final String value;

    GameConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}