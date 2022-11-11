package lotto.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YieldCalculator {

    public Map<String, Integer> getStatistics(
            List<Integer> matchResultNotContainBonusNumber, List<Integer> matchResultContainBonusNumber) {
        Map<String, Integer> winInformation = new HashMap<>() {{
            put("three", 0);
            put("four", 0);
            put("five", 0);
            put("six", 0);
            put("FiveContainingBonusNumber", 0);
        }};

        for (Integer integer : matchResultNotContainBonusNumber) {
            if (integer == 3) {
                winInformation.put("three", (winInformation.get("three") + 1));
            } else if (integer == 4) {
                winInformation.put("four", (winInformation.get("four") + 1));
            } else if (integer == 5) {
                winInformation.put("five", (winInformation.get("five") + 1));
            } else if (integer == 6) {
                winInformation.put("six", (winInformation.get("six") + 1));
            }
        }

        for (Integer integer : matchResultContainBonusNumber) {
            if (integer == 5) {
                winInformation.put("FiveContainingBonusNumber", (winInformation.get("FiveContainingBonusNumber") + 1));
            }
        }

        System.out.println("winInformation = " + winInformation);

        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winInformation.get("three"));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winInformation.get("four"));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winInformation.get("five"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winInformation.get("FiveContainingBonusNumber"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winInformation.get("six"));

        return winInformation;
    }

    public double countMatchResult(Map<String, Integer> winInformation, int purchaseMoney) {
        int result = 0;

        result += winInformation.get("three") * 5000;
        result += winInformation.get("four") * 50000;
        result += winInformation.get("five") * 1500000;
        result += winInformation.get("FiveContainingBonusNumber") * 30000000;
        result += winInformation.get("six") * 2000000000;

        return (double) result / (double) purchaseMoney * 100;
    }

    public void getYield(Map<String, Integer> winInformation, int purchaseNumber) {
        double yield = countMatchResult(winInformation, (purchaseNumber * 1000));
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
