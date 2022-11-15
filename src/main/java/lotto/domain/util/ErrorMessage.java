package lotto.domain.util;

public enum ErrorMessage {
    AMOUNT_ERROR("[ERROR] 금액은 1,000의 배수여야 합니다."),
    LOTTO_NUMBER_ERROR("[ERROR] 올바르지 않은 입력입니다."),
    OUT_OF_SIZE("[ERROR] 로또의 길이는 6이여야 합니다."),
    IS_NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    IS_DUPLICATED("[ERROR] 숫자가 중복되지 않아야 합니다."),
    IS_LOTTO_CONTAIN_BONUS("[ERROR] 보너스 숫자는 로또 숫자와 중복되면 안됩니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
