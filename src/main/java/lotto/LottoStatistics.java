package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private int winningMoney = 0;
    private Map<String, List<Integer>> countMatchingMoney = new HashMap<>();

    LottoStatistics() {
        countMatchingMoney.put("0", List.of(0, 0));
        countMatchingMoney.put("1", List.of(0, 0));
        countMatchingMoney.put("2", List.of(0, 0));
        countMatchingMoney.put("3", List.of(5000, 0));
        countMatchingMoney.put("4", List.of(50000, 0));
        countMatchingMoney.put("5", List.of(1500000, 0));
        countMatchingMoney.put("bonus", List.of(30000000, 0));
        countMatchingMoney.put("6", List.of(2000000000, 0));
    }

    public void countWinningMoney(List<Lotto> lottos, Lotto winningLotto, int bonus) {
        for (Lotto lotto : lottos) {
            String key = Integer.toString(lotto.countMatchingNumber(winningLotto.getNumbers()));
            if (key.equals("5")) {
                key = checkBonusNumber(lotto, bonus, key);
            }
            winningMoney += countMatchingMoney.get(key).get(0);
            countMatchingMoney.get(key).set(1, countMatchingMoney.get(key).get(1) + 1);
        }
    }

    public String checkBonusNumber(Lotto lotto, int bonus, String key) {
        String newKey = key;
        if (lotto.existsNumber(bonus)) {
            newKey = "bonus";
        }
        return newKey;
    }

    public double getProfits(List<Lotto> lottos, Lotto winningLotto, int bonus, int money) {
        countWinningMoney(lottos, winningLotto, bonus);
        double profits = (double) winningMoney / money;
        return profits;
    }

    public Map<String, List<Integer>> getCountMatchingMoney() {
        return countMatchingMoney;
    }
}
