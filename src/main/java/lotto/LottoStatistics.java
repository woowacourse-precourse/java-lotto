package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private int winningMoney = 0;
    private Map<String, Integer> countMatchingMoney = new HashMap<>();

    LottoStatistics() {
        countMatchingMoney.put("0", 0);
        countMatchingMoney.put("1", 0);
        countMatchingMoney.put("2", 0);
        countMatchingMoney.put("3", 5000);
        countMatchingMoney.put("4", 50000);
        countMatchingMoney.put("5", 1500000);
        countMatchingMoney.put("bonus", 30000000);
        countMatchingMoney.put("6", 2000000000);
    }

    public void countWinningMoney(List<Lotto> lottos, Lotto winningLotto, int bonus) {
        for (Lotto lotto : lottos) {
            String key = Integer.toString(lotto.countMatchingNumber(winningLotto.getNumbers()));
            if (key.equals("5")) {
                key = checkBonusNumber(lotto, bonus, key);
            }
            winningMoney += countMatchingMoney.get(key);
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
}
