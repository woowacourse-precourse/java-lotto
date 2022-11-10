package lotto.calculator;

import java.math.BigDecimal;
import java.util.List;

public class YieldCalculator {

    public void getStatistics(List<Integer> winCount) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winCount.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winCount.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winCount.get(2));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winCount.get(3));
    }

    public void getYield(BigDecimal yield) {
        System.out.printf("총 수익률은 %s" + "%입니다.", yield);
    }
}
