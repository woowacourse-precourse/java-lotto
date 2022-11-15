package lotto;

public class LottoConstant {
    public static final String GAME_START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_LOTTO_COUNT_RESULT_MESSAGE = "개를 구매했습니다.";
    public static final String INPUT_WINNING_LOTTO_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public static final String STATISTICS_PRINT_MESSAGE = "\n당첨통계\n---\n";
    public static final String TOTAL_RATE_MESSAGE_1 = "총 수익률은 ";
    public static final String TOTAL_RATE_MESSAGE_2 = "%입니다.";

    public static final String PURCHASE_AMOUNT_INPUT_IS_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력값이 올바른 숫자가 아닙니다.";
    public static final String PURCHASE_AMOUNT_INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE = "[ERROR] 로또를 구매하기에 너무 작은 금액입니다.";
    public static final String PURCHASE_AMOUNT_INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE = "[ERROR] 입력 금액이 1000으로 나누어 떨어지지 않습니다.";
    public static final String WINNING_LOTTO_NUMBER_INPUT_IS_NOT_MATCH_REGEX_ERROR_MESSAGE = "[ERROR] 입력 로또 번호가 올바르지 않습니다.";
    public static final String WINNING_LOTTO_NUMBER_INPUT_IS_NOT_IN_LOTTO_RANGE_ERROR_MESSAGE = "[ERROR] 입력 로또 번호중 숫자가 아닌 값이 있습니다.";
    public static final String WINNING_LOTTO_NUMBER_INPUT_HAS_SAME_NUMBER_ERROR_MESSAGE = "[ERROR] 입력 로또 번호중 같은 값이 있습니다.";
    public static final String BONUS_NUMBER_INPUT_IS_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력 보너스 번호가 숫자가 아닙니다.";
    public static final String BONUS_NUMBER_INPUT_IS_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 입력 로또 번호가 올바르지 않습니다.";

    private LottoConstant() {
    }
}
