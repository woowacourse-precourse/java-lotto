package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {
    private static final String BUY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNER_STATISTICS = "\n당첨 통계\n";
    private static final String BAR = "---\n";
    private static final String MATCH_MESSAGE = "%d개 일치";
    public static final String PRICE_AND_WINNING_COUNT_FORMAT = " (%,3d원) - %d개\n";
    private static final String BONUS_BALL = ", 보너스 볼 일치";
    private static final String TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.";

    public static void printBuy(int count) {
        System.out.printf(BUY_MESSAGE, count);
    }

    public static void printTicket(LottoTicket ticket) {
        for (Lotto lotto : ticket.getTicket()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics() {
        System.out.printf(WINNER_STATISTICS);
        System.out.printf(BAR);
    }

    public static void printWinningState(Result result) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            generateResultBoard(rank, count, sb);
        }
        System.out.printf(sb.toString());
    }

    private static void generateResultBoard(Rank rank, int count, StringBuilder sb) {
        if (rank.getMatchCount() == 0) {
            return;
        }
        String countSentence = String.format(MATCH_MESSAGE, rank.getMatchCount());
        sb.append(countSentence);
        if (rank.getBonus()) {
            sb.append(BONUS_BALL);
        }
        String str = String.format(PRICE_AND_WINNING_COUNT_FORMAT, rank.getPrize(), count);
        sb.append(str);
    }

    public static void printProfit(double profit) {
        System.out.printf(TOTAL_PROFIT, profit);
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}

