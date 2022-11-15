package lotto.util;

import static lotto.domain.Rank.SECOND;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class PrintService {

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistic(Map<Rank, Integer> rankCountMap, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        rankCountMap.forEach(PrintService::printEachWinningStatistic);
        printYield(yield);
    }

    private static void printEachWinningStatistic(Rank rank, int rankCount) {
        String matchedNumberMessage = "%d개 일치";
        String amountMessage = " (%,d원) - %d개";
        if (rank.equals(SECOND)) {
            matchedNumberMessage += ", 보너스 볼 일치";
        }
        String message = String.format(matchedNumberMessage + amountMessage,
            rank.getMatchedNumbers(), rank.getWinningAmount(), rankCount);
        System.out.println(message);
    }

    public static void printYield(double yield) {
        System.out.println(String.format("총 수익률은 %.1f", yield) + "%입니다.");
    }
}
