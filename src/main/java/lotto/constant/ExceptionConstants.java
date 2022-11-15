package lotto.constant;

import static lotto.constant.GameConstants.*;

public enum ExceptionConstants {

    NOT_NATURAL_NUMBER("자연수를 입력해야 합니다."),
    LEADING_ZERO("각 번호는 0으로 시작할 수 없습니다."),
    WRONG_RANGE(String.format("각 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER)),
    DUPLICATION("각 번호는 서로 중복되지 않아야 합니다."),
    WRONG_LENGTH("%d개의 자연수여야 합니다."),
    INDIVISIBLE_PURCHASE_AMOUNT(String.format("구입금액은 %d의 배수여야 합니다.", LOTTO_PRICE));

    private final String message;
    private static final String PREFIX = "[ERROR] ";

    ExceptionConstants(String message) {
        this.message = PREFIX + message;
    }

    @Override
    public String toString() {
        return message;
    }
}
