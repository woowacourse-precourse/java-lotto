package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningCount {
    private Map<String, Integer> count;

    public WinningCount() {
        count = new HashMap<>();
        count.put("3", 0);
        count.put("4", 0);
        count.put("5", 0);
        count.put("6", 0);
        count.put("bonus", 0);
    }

    public Map<String, Integer> getCount() {
        return count;
    }

    public void addWinningResult(String str, boolean bonusCheck) {
        if (bonusCheck && str == "5") {
            count.put("bonus", count.get("bonus"));
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
