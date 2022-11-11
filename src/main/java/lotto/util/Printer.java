package lotto.util;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Rank;

public class Printer {

    public static void println(List<Lotto> expectedLottos) {
        for (Lotto expectedLotto : expectedLottos) {
            System.out.println(expectedLotto);
        }
        System.out.println();
    }

    public static void println(Map<Rank, Long> statistics) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : statistics.keySet()) {
            System.out.println(rank + " - " + statistics.get(rank) + "개");
        }
    }

    private static long getEarnMoney(Map<Rank, Long> statistics) {
        long sum = 0;
        for (Rank rank : statistics.keySet()) {
            sum += rank.getRewardMoney() * statistics.get(rank);
        }
        return sum;
    }

    public static void printlnEarningMoney(Money money, Map<Rank, Long> statistics) {
        long benefit = getEarnMoney(statistics);
        System.out.printf("총 수익률은 %s%%입니다.\n", money.getBenefits(benefit));
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
