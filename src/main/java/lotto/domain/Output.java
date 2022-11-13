package lotto.domain;

import java.util.List;
import java.util.Map;

public class Output {
    private static final String BUY_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";

    public void buyLottoCount(int purchase) {
        System.out.printf(BUY_LOTTO_COUNT, purchase / 1000);
    }

    public void everyLottoNumber(int purchase, List<List<Integer>> generatorNumbers) {
        for (List<Integer> number : generatorNumbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    public void result(int purchase, Referee referee, Map<Rank, Integer> ranking) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", ranking.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", ranking.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", ranking.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", ranking.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", ranking.getOrDefault(Rank.FIRST, 0));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", (referee.getTotalPrize() / purchase) * 100);
    }
}
