package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;

public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    INVALID_UNIT_OF_BUDGET(String.format("%d원 단위로 구매 가능합니다.", LOTTO_PRICE)),
    INVALID_WINNING_NUMBER_SIZE("6개의 당첨 번호를 입력해 주세요."),
    INVALID_WINNING_NUMBER_DUPLICATE("당첨 번호 중 중복되는 숫자가 있습니다."),
    INVALID_WINNING_NUMBER_LOTTO_RANGE("1에서 45 사이의 자연수만 입력 가능합니다."),
    BONUS_NUMBER_DUPLICATED("당첨 번호와 보너스 번호가 중복됩니다.");
    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
