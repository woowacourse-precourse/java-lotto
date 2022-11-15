package lotto.util;

public class Constant {

    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PURCHASE_COST = 1000;

    public static final String WINNING_NUMBER_REGEX = "^[1-9,]*$";
    public static final String COMMA = ",";
    public static final String NUMBER_REGEX = "^[1-9]*$";
    public static final String LOTTO_PURCHASE_REGEX = "^[0-9]*$";
    public static final String ROUND_SECOND_DECIMAL_PLACE = "%.1f";
    public static final String PERCENT = "100.0";
    public static final String DECIMAL_FORMAT = "###,###";
    public static final String RANK_SECOND = "SECOND";

    public static final String ERROR_MSG_SAME_NUMBER = "[ERROR] 서로 다른 숫자로 구성되어 있지 않습니다.";
    public static final String ERROR_MSG_OTHER_NUMBER_BETWEEN_1_AND_45 = "[ERROR] 로또 번호가 1과 45사이의 수로 구성되어 있지 않습니다.";
    public static final String ERROR_MSG_BONUS_OTHER_NUMBER_BETWEEN_1_AND_45 = "[ERROR] 잘못된 보너스 번호 입니다.";
    public static final String ERROR_MSG_BONUS_CONSIST_OF_LOTTO = "[ERROR] 보너스 번호는 당첨 번호 이외의 숫자이어야 합니다.";
    public static final String ERROR_MSG_PURCHASE_MONEY = "[ERROR] 로또 구입 금액은 1000의 배수여야 합니다.";
    public static final String ERROR_MSG_INVALID_INPUT = "[ERROR] 당첨 번호는 숫자와 ,로만 구셩되어야 합니다.";
    public static final String ERROR_MSG_START_OR_END_COMMA = "[ERROR] 콤마는 처음과 끝이면 안됩니다.";
    public static final String ERROR_MSG_NOT_NUMBER = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    public static final String ERROR_MSG_PURCHASE_MONEY_CONSIST_OF_NUM = "[ERROR] 로또 구입 금액은 숫자여야 합니다.";

    public static final String PURCHASE_LOTTO_TICKETS_MSG = "%n%d개를 구매했습니다.%n";
    public static final String WINNING_STATS_MSG = "\n당첨 통계\n---";
    public static final String WINNING_STATS_RANK_SECOND_MSG = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    public static final String WINNING_STATS_OTHER_RANK_MSG = "%d개 일치 (%s원) - %d개%n";
    public static final String YIELD_MSG = "총 수익률은 %s%%입니다.";
    public static final String INPUT_PURCHASE_MONEY_MSG = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO_MSG = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_MSG = "\n보너스 번호를 입력해 주세요.";
}
