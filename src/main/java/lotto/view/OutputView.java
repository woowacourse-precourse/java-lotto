package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.domain.Stats;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.getCount());
        System.out.println(lottos);
    }

    public static void printStats(Stats stats) {
        printLottoResult(stats.getLottoResult());
        printRateOfProfit(stats.getRateOfProfit());
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.get(Ranking.FIFTH.name()));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult.get(Ranking.FOURTH.name()));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.get(Ranking.THIRD.name()));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.get(Ranking.SECOND.name()));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.get(Ranking.FIRST.name()));
    }

    public static void printRateOfProfit(double rateOfProfit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfProfit);
    }

}
