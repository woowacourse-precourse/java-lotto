package lotto.domain;

public class ErrorMessage {
    static final String PURCHASE_AMOUNT_IS_NOT_INT_ERROR_MESSAGE = "[ERROR] 구입금액은 숫자여야 합니다.";
    static final String NOT_DEVIDED_BY_LOTTO_PIRCE_ERROR_MESSAGE = "[ERROR] 구입금액은 %d원 단위여야 합니다.";
    static final String WINNING_NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 당첨 번호의 개수가 %d개가 아닙니다.";
    static final String WINNING_NUMBER_IS_NOT_INT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 숫자여야 합니다.";
    static final String WINNING_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.";
    static final String WINNING_NUMBER_IS_DUPLICATED_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복이 없어야 합니다.";
    static final String BONUS_IS_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.";
    static final String BONUS_IS_DUPLICATED_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.";
    static final String BONUS_IS_NOT_INT_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
}
