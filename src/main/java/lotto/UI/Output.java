package lotto.UI;

import java.util.Comparator;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class Output {

    public static void printLotteries(Map<Lotto, Bonus> lotteries) {
        System.out.println();
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lotto : lotteries.keySet()) {
            lotto.getNumbers().sort(Comparator.naturalOrder());
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printResult(String resultPrintFormat) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(resultPrintFormat);
    }

    public static void printEarningRate(float earningRate) {

    }

}
