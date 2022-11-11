package lotto.constant;

public enum StringConstant {
    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_LOTTERY_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    MONEY_INPUT_NOT_DIVIDE_BY_LOTTO_MONEY_PER_ONE_MESSAGE("[ERROR] 로또 가격의 배수를 입력해야 합니다."),
    MONEY_INPUT_NOT_NUMERIC_FORM_ERROR_MESSAGE("[ERROR] 양의 정수 형태여야 합니다."),
    MONEY_INPUT_MINUS_VALUE_ERROR_MESSAGE("[ERROR] 로또 번호는 양수여야 합니다."),
    LOTTO_INPUT_LENGTH_ERROR_MESSAGE("[ERROR] 로또 번호는 길이가 " + IntConstant.LOTTO_NUMBER_COUNT.getValue() + " 이어야 합니다."),
    LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE(
            "[ERROR] 로또 번호는 " + IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue() + " 이상 "
                    + IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue() + " 이하 여야합니다."),
    BONUS_LOTTO_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    BONUS_LOTTO_INPUT_LENGTH_ERROR_MESSAGE(
            "[ERROR] 보너스 번호는 길이가 " + IntConstant.BONUS_LOTTO_NUMBER_COUNT.getValue() + " 이어야 합니다."),
    BONUS_LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE("[ERROR] 보너스 번호는 " + IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue() + " 이상 "
            + IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue() + " 이하 여야합니다.");
    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
