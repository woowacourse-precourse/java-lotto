package lotto.message;

public class Message {

    private Message() {}

    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_LOTTO_AMOUNT_MESSAGE = "\n%d개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String WIN_STATS_HEAD = "\n당첨 통계\n---";
    public static final String[] WIN_STATS_LIST = {
                                                   "꽝 (0원) - %d개",
                                                   "3개 일치 (5,000원) - %d개",
                                                   "4개 일치 (50,000원) - %d개",
                                                   "5개 일치 (1,500,000원) - %d개",
                                                   "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
                                                   "6개 일치 (2,000,000,000원) - %d개"
                                                   };
    public static final String WIN_YIELD = "총 수익률은 %.1f%%입니다.";

    
    
}
