package lotto.view;

public abstract class ConsoleMessage {
    public static final String TYPE_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    public static final String TYPE_PRIZE_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String TYPE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String ORDER_HISTORY_HEADER = "%d개를 구매했습니다.\n";
    public static final String STATISTICS_HEADER = "당첨 통계\n---\n";
    public static final String FIFTH_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    public static final String FOURTH_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    public static final String THIRD_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    public static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    public static final String FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String PRINT_YIELD = "총 수익률은 %.1f%%입니다.\n";
}
