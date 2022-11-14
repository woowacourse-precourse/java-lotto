package lotto.ui.output;

import java.util.Map;

import static lotto.prizestandards.PrizeStandards.*;

public class PrizeListPrinter {
    private static final String THREE_MATCH_STRING = "3개 일치 (5,000원) - %d개\n";
    private static final String FOUR_MATCH_STRING = "4개 일치 (50,000원) - %d개\n";
    private static final String FIVE_MATCH_STRING = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FIVE_BONUS_MATCH_STRING = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String SIX_MATCH_STRING = "6개 일치 (2,000,000,000원) - %d개\n";

    public void printWinStatistic(Map<Enum, Integer> winnerResult, double yield) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf(THREE_MATCH_STRING, winnerResult.get(THREEMATCH));
        System.out.printf(FOUR_MATCH_STRING, winnerResult.get(FOURMATCH));
        System.out.printf(FIVE_MATCH_STRING, winnerResult.get(FIVEMATCH));
        System.out.printf(FIVE_BONUS_MATCH_STRING, winnerResult.get(FIVEBONUS));
        System.out.printf(SIX_MATCH_STRING, winnerResult.get(SIXMATCH));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
