package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Draw {
    Map<Rank, Integer> result = new HashMap<>();

    public Draw() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void drawLotto(List<Lotto> lottos, List<Integer> priceNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchNumberAmount = 0;
            int checkBonus = 0;

            matchNumberAmount = getMatchNumberAmount(priceNumbers, lotto, matchNumberAmount);
            checkBonus = getCheckBonus(bonusNumber, lotto, checkBonus);
            Rank rank = Rank.findByMatchNumber(matchNumberAmount, checkBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private int getMatchNumberAmount(List<Integer> priceNumbers, Lotto lotto, int matchNumberAmount) {
        for (int num : priceNumbers) {
            if (lotto.getNumbers().contains(num)) {
                matchNumberAmount++;
            }
        }
        return matchNumberAmount;
    }

    private int getCheckBonus(int bonusNumber, Lotto lotto, int checkBonus) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            checkBonus = 1;
        }
        return checkBonus;
    }

    public float calculateRate(int money) {
        return calculateTotalProfit() / (float) money * 100L;
    }

    public float calculateTotalProfit() {
        float sum = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            sum += Rank.valueOf(entry.getKey().toString()).getPriceMoney() * entry.getValue();
        }
        return sum;
    }
}
