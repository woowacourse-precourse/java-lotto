package lotto;

public class Constants {

    public static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final int MINIMUM_PURCHASE_AMOUNT = 1000;
    public static final String ASK_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_WINNING_NUMBERS_SEPARATOR = ",";
    public static final String ISSUED_LOTTO_NUMBERS_SEPARATOR = ", ";
    public static final String LOTTO_ISSUE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_RESULT_HEADER_MESSAGE = "당첨 통계\n---";
    public static final String LOTTO_EARNING_RATE_MESSAGE = "총 수익률은 %s%%입니다.";

    private static final String PREV_ERROR_MESSAGE = "[ERROR] ";
    public static final String PURCHASE_AMOUNT_IS_NOT_NUMBER_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "숫자가 아닙니다.";
    public static final String PURCHASE_AMOUNT_IS_NOT_IN_RANGE_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "1000원 이상이어야합니다.";
    public static final String PURCHASE_AMOUNT_IS_NOT_DIVIDED_ERROR_MESSAGE =
            PREV_ERROR_MESSAGE + "1000원으로 나누어떨어져야합니다.";
    public static final String LOTTO_NUMBER_IS_NOT_NUMBER_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "숫자가 아닙니다.";
    public static final String LOTTO_NUMBER_IS_NOT_IN_RANGE_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "1~45 수여야 합니다.";
    public static final String LOTTO_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "당첨번호가 6개여야합니다.";
    public static final String LOTTO_NUMBERS_ARE_DUPLICATED_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "로또에 중복된 숫자가 있습니다.";
    public static final String IS_NOT_LOTTO_NUMBERS_SIZE_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "로또 숫자 개수가 6개여야합니다.";

}
