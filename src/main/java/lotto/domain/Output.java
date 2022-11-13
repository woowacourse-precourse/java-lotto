package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Output {
    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n",lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResults(Integer PURCHASE_MONEY, Map<Ranking, Integer> rankResult) {
        // 당첨 내역을 출력
        printWinningResults(rankResult);
        long earning = sumEarning(rankResult);
        // 수익률 출력
        printEarningsRate(PURCHASE_MONEY, earning);
    }

    private void printWinningResults(Map<Ranking, Integer> rankResult) {
        System.out.printf(" 3개 일치 (5,000원) - %d개\n",rankResult.getOrDefault(Ranking.rank5,0));
        System.out.printf(" 4개 일치 (50,000원) - %d개\n",rankResult.getOrDefault(Ranking.rank4,0));
        System.out.printf(" 5개 일치 (1,500,000원) - %d개\n",rankResult.getOrDefault(Ranking.rank3,0));
        System.out.printf(" 5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",rankResult.getOrDefault(Ranking.rank2,0));
        System.out.printf(" 6개 일치 (2,000,000,000원) - %d개\n",rankResult.getOrDefault(Ranking.rank1,0));
    }

    private long sumEarning(Map<Ranking, Integer> rankResult) {
        int earning = 0;

        for (Ranking ranking : rankResult.keySet()) {
            earning += ranking.getPrizeMoney();
        }

        return earning;
    }

    private void printEarningsRate(Integer purchase_money, long earning) {
        DecimalFormat decFormat = new DecimalFormat("###,###.#%");

        String earningRate = decFormat.format((double) earning/purchase_money);
        System.out.printf("총 수익률은 %s입니다.\n",earningRate);
    }
}
