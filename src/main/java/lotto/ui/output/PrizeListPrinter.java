package lotto.ui.output;

import lotto.domain.PrizeListGenerator;
import lotto.domain.YieldCalculator;
import lotto.prizestandards.PrizeStandards;

import java.util.Map;

import static lotto.prizestandards.PrizeStandards.*;

public class PrizeListPrinter {
    public void printWinStatistic(Map<Enum, Integer> winnerResult, double yield) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winnerResult.get(THREEMATCH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winnerResult.get(FOURMATCH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winnerResult.get(FIVEMATCH));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winnerResult.get(FIVEBONUS));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winnerResult.get(SIXMATCH));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
