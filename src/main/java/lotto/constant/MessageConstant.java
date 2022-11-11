package lotto.constant;

public class MessageConstant {

    public static final String ERROR = "[ERROR]";
    private static final String LINE = System.lineSeparator();

    public static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LOTTO_NUMBERS = LINE + "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = LINE + "보너스 번호를 입력해 주세요.";

    public static final String OUTPUT_PURCHASE = LINE + "%d개를 구매했습니다." + LINE;
    public static final String OUTPUT_EARNING = LINE + "총 수익률은 %.1f%%입니다.";

    public static final String STATISTICS_MESSAGE = LINE + "당첨 통계" + LINE + "---";
    public static final String STATISTICS_THREE_MATCH = "3개 일치 (5,000원) - %d개";
    public static final String STATISTICS_FOUR_MATCH = LINE + "4개 일치 (50,000원) - %d개";
    public static final String STATISTICS_FIVE_MATCH = LINE + "5개 일치 (1,500,000원) - %d개";
    public static final String STATISTICS_FIVE_MATCH_ONE_BONUS = LINE + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    public static final String STATISTICS_SIX_MATCH = LINE + "6개 일치 (2,000,000,000원) - %d개";

}
