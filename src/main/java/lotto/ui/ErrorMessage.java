package lotto.ui;

public enum ErrorMessage {
    LOTTO_LENGTH_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATED_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_FORM_ERROR("[ERROR] 로또 번허의 형식이 잘못되었습니다."),
    MONEY_RANGE_ERROR("[ERROR] 금액은 1000원을 넘기거나 1000원 단위여야 합니다."),
    MONEY_FORM_ERROR("[ERROR] 금액은 원 단위로 입력해야 합니다."),
    BONUS_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_DUPLICATED_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다."),
    BONUS_FORM_ERROR("[ERROR] 보너스 번호의 형식이 잘못되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }

}
