package lotto.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YieldCalculator {

    public Map<Integer, Integer> getStatistics(List<Integer> matchResult) {
        Map<Integer, Integer> winInformation = new HashMap<>() {{
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};

        for (Integer integer : matchResult) {
            if (integer == 3) {
                winInformation.put(3, (winInformation.get(3) + 1));
            } else if (integer == 4) {
                winInformation.put(4, (winInformation.get(4) + 1));
            } else if (integer == 5) {
                winInformation.put(5, (winInformation.get(5) + 1));
            } else if (integer == 6) {
                winInformation.put(6, (winInformation.get(6) + 1));
            }
        }
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winInformation.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winInformation.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winInformation.get(5));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winInformation.get(6));

        return winInformation;
    }

    public double countMatchResult(Map<Integer, Integer> winInformation, int purchaseMoney) {
        int result = 0;

        result += winInformation.get(3) * 5000;
        result += winInformation.get(4) * 50000;
        result += winInformation.get(5) * 1500000;
        result += winInformation.get(6) * 2000000000;

        return (double) result / (double) purchaseMoney * 100;
    }

    public void getYield(Map<Integer, Integer> winInformation, int purchaseNumber) {
        double yield = countMatchResult(winInformation, (purchaseNumber * 1000));
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
