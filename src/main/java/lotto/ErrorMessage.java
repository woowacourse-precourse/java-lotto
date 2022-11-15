package lotto;

public enum ErrorMessage {
    INVALID_MONEY_ERROR("[ERROR] 1,000원 단위의 금액을 입력하여 주십시오"),
    INVALID_LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개 입니다."),
    INVALID_LOTTO_FORM_ERROR("[ERROR] 콤마로 구분하여 6개의 숫자를 입력해 주십시오."),
    INVALID_LOTTO_NUMBER_ERROR("[ERROR] 로또 번호에는 중복이 있으면 안됩니다."),
    INVALID_BONUS_NUMBER_ERROR("[ERROR] 당첨 번호와 중복되는 보너스 번호입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
