package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;

public class OutputView {

    public static void printBuyingCount(List<Lotto> lotteries) {
        System.out.printf("%n%s개를 구매했습니다.%n%n", lotteries.size());

        for (Lotto lotto : lotteries) {
            System.out.println(lotto);
        }
    }

    public static void printTotalResult(HashMap<LottoPrize, Long> prizeStatus, double earningRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        prizeStatus.keySet().forEach(
                (prize) -> {
                    System.out.printf("%s - %d개%n", prize, prizeStatus.get(prize));
                }
        );
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }
}
