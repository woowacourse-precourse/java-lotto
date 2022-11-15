package lotto.Model.enums;

public enum ErrorMessage {
    MONEY_NUMBER_ERROR("[ERROR] 금액은 숫자로 입력해야 합니다."),
    MONEY_UNIT_ERROR("[ERROR] 금액은 1000원 단위로 입력해야 합니다."),
    MONEY_ZERO_ERROR("[ERROR] 금액은 0보다 큰 수를 입력해야 합니다."),
    LOTTO_NUMBER_ERROR("[ERROR] 로또 번호는 숫자여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복되지 않은 숫자 6개를 입력해야 합니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_COUNT_ERROR("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    BONUS_DUPLICATE_ERROR("[ERROR] 보너스 번호는 중복되지 않은 숫자 6개를 입력해야 합니다."),
    BONUS_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String ErrorMessage;

    ErrorMessage(String message) {
        this.ErrorMessage = message;
    }

    public String getMessage() {
        return this.ErrorMessage;
    }
}
