package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class Output {
    public static void printQuickPick(List<Lotto> quickPicks) {
        for (Lotto lotto : quickPicks) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> rankMap, double revenue) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", rankMap.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", rankMap.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rankMap.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankMap.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rankMap.get(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue);
    }

    public static void printIllegalArgumentException(String message) {
        System.out.println(message);
    }

}
