package lotto;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBERS_SIZE_MESSAGE("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다."),
    INVALID_WINNING_NUMBERS_SIZE_MESSAGE("[ERROR] 당첨 번호는 6개의 숫자로 구성되어야 합니다."),
    DUPLICATED_NUMBERS_MESSAGE("[ERROR] 로또 번호는 중복되지 않은 숫자들로 구성되어야 합니다."),
    INVALID_LOTTO_NUMBERS_RANGE("[ERROR] 로또 번호는 1 ~ 45 범위의 숫자만 가능합니다."),
    INVALID_BONUS_NUMBER_RANGE_MESSAGE("[ERROR] 보너스 숫자는 1 ~ 45 범위만 가능합니다."),
    INVALID_WINNING_NUMBERS_RANGE_MESSAGE("[ERROR] 당첨 번호는 1 ~ 45 범위의 숫자만 가능합니다."),
    INVALID_WINNING_NUMBERS_INPUT_MESSAGE("[ERROR] 숫자와 ','만 입력 가능합니다."),
    BONUS_NUMBER_DUPLICATED_MESSAGE("[ERROR] 보너스 숫자와 중복되는 당첨번호가 존재합니다."),
    NOT_NUMBER_INPUT_MESSAGE("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_PURCHASE_MONEY_MESSAGE("[ERROR] 1,000원 단위로만 구매 가능합니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
