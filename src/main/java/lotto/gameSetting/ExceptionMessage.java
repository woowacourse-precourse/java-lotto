package lotto.gameSetting;

public enum ExceptionMessage {
    NUMBER_EXCEPTION("[ERROR] 숫자를 입력해 주세요."),
    THOUSAND_EXCEPTION("[ERROR] 로또 구입 금액은 1,000원 단위이어야 합니다."),
    RANGE_EXCEPTION("[ERROR] 1부터 45이내의 숫자를 입력하세요."),
    BONUS_OVERLAP_EXCEPTION("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않습니다."),
    OVERLAP_EXCEPTION("[ERROR] 숫자가 중복되었습니다"),
    SIZE_EXCEPTION("[ERROR] 로또 번호는 6개의 숫자를 입력하여야 합니다.")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
