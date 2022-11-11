package lotto.infrascturcture.adapter.output.calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YieldCalculator {

    Map<String, Integer> winInformation = new HashMap<>() {{
        put("three", 0);
        put("four", 0);
        put("five", 0);
        put("six", 0);
        put("FiveContainingBonusNumber", 0);
    }};

    public Map<String, Integer> extractStatistic(List<List<Integer>> matchResult) {

        List<Integer> matchResultNotConsiderBonus = matchResult.get(0);
        List<Integer> bonusMatchingCount = matchResult.get(1);

        for (Integer integer : matchResultNotConsiderBonus) {
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
        winInformation = considerBonusNumber(bonusMatchingCount);
        return winInformation;
    }

    public Map<String, Integer> considerBonusNumber(List<Integer> bonusMatchingCount) {
        for (Integer integer : bonusMatchingCount) {
            if (integer == 1) {
                winInformation.put("FiveContainingBonusNumber", (winInformation.get("FiveContainingBonusNumber") + 1));
            }
        }
        winInformation.put("five", winInformation.get("five") - winInformation.get("FiveContainingBonusNumber"));
        return winInformation;
    }

    public void showStatistic(Map<String, Integer> winInformation) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winInformation.get("three"));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winInformation.get("four"));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winInformation.get("five"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winInformation.get("FiveContainingBonusNumber"));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winInformation.get("six"));
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
        System.out.printf("총 수익률은 %s%%입니다.", Math.round(yield * 10) / 10.0);
    }
}
