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

    public void addWinningResult(String result, boolean bonusCheck) {
        if (bonusCheck && result == "5") {
            count.put("bonus", count.get("bonus") + 1);
            return;
        }
        if (count.containsKey(result)) {
            count.put(result, count.get(result) + 1);
        }

    }

    public int getProfitSum() {
        int profitSum = 0;
        for (String profit : count.keySet()) {
            profitSum = calculateProfit(profitSum, profit);
        }
        return profitSum;
    }

    public int calculateProfit(int profitSum, String profit) {
        if (profit == Constant.FIFTH_PLACE) {
            profitSum += Constant.FIFTH_PLACE_PRIZE * count.get(Constant.FIFTH_PLACE);
        }
        if (profit == Constant.FOURTH_PLACE) {
            profitSum += Constant.FOURTH_PLACE_PRIZE * count.get(Constant.FOURTH_PLACE);
        }
        if (profit == Constant.THIRD_PLACE) {
            profitSum += Constant.THIRD_PLACE_PRIZE * count.get(Constant.THIRD_PLACE);
        }
        if (profit == Constant.SECOND_PLACE) {
            profitSum += Constant.SECOND_PLACE_PRIZE * count.get(Constant.SECOND_PLACE);
        }
        if (profit == Constant.FIRST_PLACE) {
            profitSum += Constant.FIRST_PLACE_PRIZE * count.get(Constant.FIRST_PLACE);
        }
        return profitSum;
    }
}
