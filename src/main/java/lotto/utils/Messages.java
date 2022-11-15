package lotto.utils;

public class Messages {

    public static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WIN_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static final String PRINT_RANK_MATCHCOUNT_MESSAGE = "%d개 일치";
    public static final String PRINT_RANK_WINMONEY_AND_COUNT_MESSAGE = " (%s원) - %d개\n";
    public static final String PRINT_NOT_BONUS_MESSAGE = "";
    public static final String PRINT_BONUS_MESSAGE = ", 보너스 볼 일치";
    public static final String PRINT_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String PRINT_PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다." + System.lineSeparator();
    public static final String PRINT_RESULT_START_MESSAGE = "\n당첨 통계" + System.lineSeparator() + "---------";

    public static final String ERROR_PATTERN_MESSAGE = "[ERROR] 로또 번호는 1,2,3,4,5,6 과 같은 패턴이어야 합니다.";
    public static final String ERROR_LENGTH_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자가 입력되어야 합니다.";
    public static final String ERROR_RANGE_MESSAGE = "[ERROR] 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATION_MESSAGE = "[ERROR] 중복이 없어야 합니다.";
    public static final String ERROR_DIGIT_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    public static final String ERROR_PLUS_NUMBER_MESSAGE = "[ERROR] 구입금액은 0보다 큰 숫자여야 합니다.";
    public static final String ERROR_UNIT_MESSAGE = "[ERROR] 구입금액은 1000단위 이어야 합니다.";

}
