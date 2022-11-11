package lotto.constant;

public enum ErrorMessage {
    ERROR_MESSAGE_PREFIX("[ERROR] "),
    UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE("구매 단위에 맞지 않게 입력하셨습니다"),
    CAN_NOT_EXIST_DUPLICATE_NUMBER_IN_LOTTO("로또에 중복된 숫자는 존재할 수 없습니다"),
    LOTTO_NUMBER_IS_OUT_OF_RANGE("범위 밖의 로또 번호입니다"),
    BONUS_NUMBER_AND_WINNING_LOTTO_NUMBERS_ARE_DUPLICATE("보너스 숫자와 당첨 로또 번호가 중복됩니다"),
    MONEY_IS_ALLOWED_ONLY_NUMERIC("구매 입력은 숫자만 가능합니다"),
    USER_INPUT_DOES_NOT_COMPLY_WITH_RULE_FOR_WINNING_LOTTO_NUMBER("입력한 당첨 번호 형식은 게임 규칙에 맞지 않습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX.message + message;
    }
}
