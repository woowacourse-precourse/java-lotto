package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.List;

public class OutputView {

    public static void printLottoPurchaseInputNotice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningNumberInputNotice() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputNotice() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoPurchaseResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printWinningStatistics(int[] rankingCount) {
        System.out.println("당첨 통계\n" +
                            "---");
        int rankingIndex = 5;
        for (Ranking ranking : Ranking.values()) {
            String condition = ranking.getCondition();
            String reward = ranking.getReward();
            int count = rankingCount[rankingIndex--];

            System.out.printf("%s (%s) - %d개\n", condition, reward, count);
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }
}
