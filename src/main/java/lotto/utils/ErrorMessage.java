package lotto.utils;

public enum ErrorMessage {
    PURCHASE_AMOUNT_ERROR("[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다."),
    PURCHASE_AMOUNT_TYPE_ERROR("[ERROR] 로또 구입 금액은 숫자여야 합니다."),
    LOTTO_NUMBER_LENGTH_ERROR("[ERROR] 로또 번호의 개수는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호의 범위는 1부터 45까지 입니다."),
    LOTTO_NUMBER_DUPLICATED_ERROR("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    WINING_NUMBER_SPLIT_LENGTH_ERROR("[ERROR] 당첨 번호는 쉼표로 구분된 6자리 숫자여야 합니다."),
    BONUS_NUMBER_LENGTH_ERROR("[ERROR] 보너스 번호는 1개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
