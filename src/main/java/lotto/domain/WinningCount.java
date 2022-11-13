package lotto.domain;

import lotto.Constant;

import java.util.HashMap;
import java.util.Map;

public class WinningCount {
    private Map<String, Integer> count;

    public WinningCount() {
        count = new HashMap<>();
        count.put(Constant.FIRST_PLACE, 0);
        count.put(Constant.SECOND_PLACE, 0);
        count.put(Constant.THIRD_PLACE, 0);
        count.put(Constant.FOURTH_PLACE, 0);
        count.put(Constant.FIFTH_PLACE, 0);
    }

    public Map<String, Integer> getCount() {
        return count;
    }

    public void addWinningResult(String str, boolean bonusCheck) {
        if (bonusCheck && str == "5") {
            count.put("bonus", count.get("bonus") + 1);
            return;
        }
        if (count.containsKey(str)) {
            count.put(str, count.get(str) + 1);
        }
    }

    public int getProfitSum() {
        int profitSum = 0;
        for (String profit : count.keySet()) {
            profitSum = calculateProfit(profitSum, profit);
        }
        return profitSum;
    }

    private int calculateProfit(int profitSum, String profit) {
        if (profit == "3") {
            profitSum += 5000 * count.get("3");
        }
        if (profit == "4") {
            profitSum += 50000 * count.get("4");
        }
        if (profit == "5") {
            profitSum += 1500000 * count.get("5");
        }
        if (profit == "bonus") {
            profitSum += 30000000 * count.get("bonus");
        }
        if (profit == "6") {
            profitSum += 2000000000 * count.get("6");
        }
        return profitSum;
    }

}
