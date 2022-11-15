package lotto.constants;

public enum ExceptionConstants {

    // user
    USER_INPUT_COST("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다"),

    // lotto
    LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATED("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    LOTTO_BONUS_DUPLICATED("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    LOTTO_BONUS_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String value;

    ExceptionConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
