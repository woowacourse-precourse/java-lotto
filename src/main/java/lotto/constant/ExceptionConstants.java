package lotto.constant;

import static lotto.constant.GameConstants.*;

public enum ExceptionConstants {

    PURCHASE_AMOUNT_NOT_NATURAL_NUMBER_EXCEPTION("구입금액은 자연수여야 합니다."),
    PURCHASE_AMOUNT_WITH_LEADING_ZERO("구입금액은 0으로 시작할 수 없습니다."),
    PURCHASE_AMOUNT_INDIVISIBILITY_EXCEPTION(String.format("구입금액은 %d의 배수여야 합니다.", LOTTO_PRICE)),

    LOTTO_NUMBER_LENGTH_EXCEPTION(String.format("로또 번호는 %d개이어야 합니다.", LOTTO_NUMBER_LENGTH)),
    LOTTO_NUMBER_RANGE_EXCEPTION(String.format("각 로또 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER)),
    LOTTO_NUMBER_DUPLICATED_EXCEPTION("로또 번호는 서로 중복되지 않아야 합니다."),

    WINNING_NUMBER_NOT_NATURAL_NUMBER_EXCEPTION("각 당첨 번호는 자연수여야 합니다."),
    WINNING_NUMBER_WITH_LEADING_ZERO("각 당첨 번호는 0으로 시작할 수 없습니다."),
    WINNING_NUMBER_LENGTH_EXCEPTION(String.format("당첨 번호는 %d개이어야 합니다.", WINNING_NUMBER_LENGTH)),
    WINNING_NUMBER_RANGE_EXCEPTION(String.format("각 당첨 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER)),
    WINNING_NUMBER_DUPLICATED_EXCEPTION("당첨 번호는 서로 중복되지 않아야 합니다."),

    BONUS_NUMBER_NOT_NATURAL_NUMBER_EXCEPTION("보너스 번호는 자연수여야 합니다."),
    BONUS_NUMBER_WITH_LEADING_ZERO("보너스 번호는 0으로 시작할 수 없습니다."),
    BONUS_NUMBER_RANGE_EXCEPTION(String.format("보너스 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER)),
    BONUS_NUMBER_DUPLICATED_EXCEPTION("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");


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
