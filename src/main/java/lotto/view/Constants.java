package lotto.view;

public class Constants {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int COUNT = 6;

    public static final String INPUT_MONEY = "구입 금액을 입력해 주세요.";
    public static final String BOUGHT_NOTICE = "%d개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STAT = "당첨 통계\n---";
    public static final String SAME_THREE = "3개 일치 (5,000원) - %d개";
    public static final String SAME_FOUR = "4개 일치 (50,000원) - %d개";
    public static final String SAME_FIVE = "5개 일치 (1,500,000원) - %d개";
    public static final String SAME_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    public static final String SAME_SIX = "6개 일치 (2,000,000,000원) - %d개";
    public static final String EARNED_RATE = "총 수익률은 %.f입니다.";

    public static final String ERROR_ALERT = "[ERROR] ";
    public static final String NOT_DIVISIBLE_BY_THOUSAND = ERROR_ALERT + "1000원 단위로 값을 지불해야 합니다.";
    public static final String BOUGHT_NOTHING = ERROR_ALERT + "로또 용지를 1개 이상 구입해야 합니다.";
    public static final String NOT_SIX = ERROR_ALERT + "당첨 번호는 6개여야 합니다.";
    public static final String DUPLICATED_VALUE = ERROR_ALERT + "중복된 값이 있으면 안 됩니다.";
    public static final String NOT_NUMERIC = ERROR_ALERT + "입력값은 숫자여야 합니다.";
    public static final String NOT_PROPER_NUMBER = ERROR_ALERT + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String CANNOT_BE_BONUS = ERROR_ALERT + "보너스 번호는 당첨 번호에 없는 번호여야 합니다.";
}
