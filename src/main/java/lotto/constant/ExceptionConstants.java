package lotto.constant;

import static lotto.constant.GameConstants.*;

public enum ExceptionConstants {

    NOT_NATURAL_NUMBER_EXCEPTION("자연수를 입력해야 합니다."),
    LEADING_ZERO_EXCEPTION("각 번호는 0으로 시작할 수 없습니다."),
    RANGE_EXCEPTION(String.format("각 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER)),
    DUPLICATED_EXCEPTION("각 번호는 서로 중복되지 않아야 합니다."),
    LENGTH_EXCEPTION("%d개의 자연수여야 합니다."),
    PURCHASE_AMOUNT_INDIVISIBILITY_EXCEPTION(String.format("구입금액은 %d의 배수여야 합니다.", LOTTO_PRICE));

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
