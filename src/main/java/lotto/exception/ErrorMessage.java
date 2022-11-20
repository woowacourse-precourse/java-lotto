package lotto.exception;

public enum ErrorMessage {
    NOT_DIVISION_PRICE("[ERROR] 지불금액이 1000으로 나누어 떨어지지 않습니다."),
    NOT_INTEGER_PRICE("[ERROR] 지불금액에 정수값이 아닌 값이 포함되어 있습니다."),
    LOTTO_NOT_INTEGER("[ERROR] 로또 번호에 정수값이 아닌 값이 포함되어 있습니다."),
    LOTTO_DUPLICATION("[ERROR] 로또 번호중에서 중복 숫자가 있습니다."),
    LOTTO_NOT_IN_RAGE("[ERROR] 로또 번호가 1 ~ 45 범위안에 포함되지 않습니다."),
    LOTTO_NOT_SIX_NUMBER("[ERROR] 로또의 한 줄당 숫자가 6개가 아닙니다."),
    LOTTO_BONUS_NOT_IN_RAGE("[ERROR] 보너스 번호가 1 ~ 45 범위안에 포함되지 않습니다."),
    LOTTO_BONUS_DUPLICATION("[ERROR] 보너스 번호가 당첨번호와 중복되면 안됩니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
