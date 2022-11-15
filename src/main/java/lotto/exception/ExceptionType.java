package lotto.exception;

public enum ExceptionType {
    MONEY_TYPE_EXCEPTION("[ERROR] 돈은 정수값이 입력되어야 합니다."),
    MONEY_VALUE_EXCEPTION("[ERROR] 돈은 1,000원 단위로 입력되어야 합니다."),
    MONEY_MINIMUM_VALUE_EXCEPTION("[ERROR] 최소 입력 금액은 1,000원 입니다"),
    LOTTO_INPUT_FORMAT_EXCEPTION("[ERROR] 입력 형식은 숫자 6개와 사이에 쉼표를 넣어 입력해야 합니다."),
    LOTTO_RANGE_EXCEPTION("[ERROR] 숫자는 1이상 45이하여야 합니다."),
    LOTTO_DUPLICATE_EXCEPTION("[ERROR] 중복된 숫자를 입력할 수 없습니다."),
    BONUS_INPUT_TYPE_EXCEPTION("[ERROR] 보너스 넘버에는 숫자를 입력해야 합니다."),
    BONUS_DUPLICATE_EXCEPTION("[ERROR] 보너스 숫자가 로또 숫자 안에 포함되어있으면 안됩니다."),
    ;

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
