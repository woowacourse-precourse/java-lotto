package lotto.view.print;

import lotto.domain.LottoHistory;
import lotto.domain.enums.LottoRanking;
import lotto.view.print.enums.WinningHistoryMessage;

public class PrintHistory {
    private static final String YIELD_MESSAGE = "총 수익률은 %s%%입니다.%n";

    public static void printWinningHistory(LottoHistory history) {
        for (WinningHistoryMessage msg : WinningHistoryMessage.values()) {
            int count = history.getWinningCount(history.getWinningHistory(), LottoRanking.valueOf(msg.getRanking()));
            System.out.printf(msg.getMessage() + "%d개\n", count);
        }
    }

    public static void printYield(String yield) {
        System.out.printf(YIELD_MESSAGE, yield);
    }
}