package lotto.util;

public class Constants {
    public static final int MONETARY_UNIT = 1000;
    public static final int LOTTO_START_RANGE = 1;
    public static final int LOTTO_END_RANGE = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int INIT_MATCHING_POINT = 0;
    public static final int EXTRA_POINT_WHEN_MATCH = 1;
    public static final int EXTRA_POINT_WHEN_MISMATCH = 0;
    public static final int INIT_COUNT = 0;
    public static final int VALUE_FOR_UPDATE_COUNT = 1;
    public static final int INIT_PROFIT = 0;


    public static final String RESULT_SEPARATOR = "\n";
    public static final String INPUT_SEPARATOR = ",";

    public static final String INPUT_PRICE_GUIDE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_GUIDE = "\n%d개를 구매했습니다.%n";
    public static final String INPUT_WINNING_LOTTO_GUIDE = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_GUIDE = "\n보너스 번호를 입력해 주세요.";
    public static final String RESULT_START_GUIDE = "\n당첨 통계\n---";
    public static final String PROFIT_RATE_GUIDE = "총 수익률은 %.2f%%입니다.";
    public static final String CONDITION_MATCHING_INFORMATION_GUIDE = "%d개 일치";
    public static final String BONUS_BALL_MATCHING_INFORMATION_GUIDE = ", 보너스 볼 일치";
    public static final String BONUS_BALL_MISMATCHING_INFORMATION_GUIDE = "";
    public static final String PRIZE_MONEY_INFORMATION_GUIDE = " (%,d원)";
    public static final String  COUNT_INFORMATION_GUIDE = " - %d개";


    public static final String INPUT_IS_NOT_NUMBER = "[ERROR] 로또 번호는 숫자여야 합니다.";
    public static final String INPUT_IS_NEGATIVE_NUMBER = "[ERROR] 로또 번호는 양수여야합니다.";
    public static final String INVALID_MONETARY_UNIT =
            String.format("[ERROR] 구입 금액은 %d 단위의 값이어야 합니다.", MONETARY_UNIT);
    public static final String INVALID_SIZE = "[ERROR] 로또는 총 %d개의 번호로 이뤄져야 합니다.";
    public static final String INVALID_RANGE =
            String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_START_RANGE, LOTTO_END_RANGE);
    public static final String DUPLICATED_NUMBER_LIST = "[ERROR] 로또 번호는 중복된 값이 존재해선 안됩니다.";
    public static final String DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 일치할 수 없습니다.";
}
