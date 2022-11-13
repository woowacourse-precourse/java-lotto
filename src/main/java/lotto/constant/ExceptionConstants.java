package lotto.constant;

import static lotto.constant.LottoConstants.*;

public enum ExceptionConstants {

    PURCHASE_AMOUNT_NOT_NATURAL_NUMBER_EXCEPTION("구입금액은 자연수여야 합니다."),
    PURCHASE_AMOUNT_INDIVISIBILITY_EXCEPTION(String.format("구입금액은 %d의 배수여야 합니다.", LOTTO_PRICE)),

    WINNING_NUMBER_FORMAT_EXCEPTION(""),
    LOTTO_NUMBER_NOT_NATURAL_NUMBER_EXCEPTION("로또 번호는 자연수여야 합니다."),
    LOTTO_NUMBER_RANGE_EXCEPTION(String.format("로또 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER)),
    LOTTO_NUMBER_DUPLICATED_EXCEPTION("로또 번호는 서로 중복되지 않아야 합니다.");

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
