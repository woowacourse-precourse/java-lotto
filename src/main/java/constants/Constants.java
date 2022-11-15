package constants;

public final class Constants {
    public static final String START_MSG = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_CNT_MSG = "개를 구매했습니다.";
    public static final String SCAN_ANSWER_MSG = "당첨 번호를 입력해 주세요. ";
    public static final String SCAN_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.";
    public static final String PRINT_STATISTICS_MSG = "당첨 통계\n" + "---";
    public static final String PRINT_PROFIT_FORMAT = "총 수익률은 %,.1f%%입니다.";
    public static final String PRINT_RANK_FORMAT = "%d개 일치%s (%,d원) - %d개";
    public static final String PRINT_BONUS_MATCH = ", 보너스 볼 일치";
    public static final String BLANK_BR = "\n";

    public static final String INPUT_NOT_INTEGER_ERROR = "[ERROR] 숫자를 입력하셔야 합니다.";
    public static final String PAY_MONEY_ERROR = "[ERROR] 구입금액은 0원이상, 1000원 단위로 끝나야 합니다.";
    public static final String ANSWER_COUNT_LOWER_ERROR = "[ERROR] 로또 당첨 번호의 숫자 개수가 부족합니다";
    public static final String ANSWER_COUNT_OVER_ERROR = "[ERROR] 로또 당첨 번호의 숫자 개수가 6개를 초과하였습니다.";
    public static final String ANSWER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ANSWER_DUPLICATE_ERROR = "[ERROR] 로또 당첨 번호는 중복되지 않는 숫자 여야 합니다.";
    public static final String BONUS_DUPLICATE_ERROR = "[ERROR] 보너스 번호는는 로또 당첨 번호와 중복되지 않는 숫자 여야 합니다.";

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_RANGE_START = 1;
    public static final int LOTTO_RANGE_END = 45;
    public static final int LOTTO_NUMS_SIZE = 6;
}
