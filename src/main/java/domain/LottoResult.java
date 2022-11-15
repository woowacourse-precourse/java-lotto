package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Integer> lottoStatistics;
    private final int money;
    private int winningMoney = 0;
    private static final Map<Integer, Integer> winningAmount;
    static {
        winningAmount = new HashMap<>();
        winningAmount.put(0, 5000);
        winningAmount.put(1, 50000);
        winningAmount.put(2, 1500000);
        winningAmount.put(3, 30000000);
        winningAmount.put(4, 2000000000);
    }

    public LottoResult(List<Integer> lottoStatistics, int money) {
        this.lottoStatistics = lottoStatistics;
        this.money = money;
    }

    public String getWinningResult() {
        for (int i = 0; i < 5; i++) {
            int number = lottoStatistics.get(i);
            addAmount(winningAmount.get(i),number);

        }

    }

    private void addAmount(int amount, int count) {
        int sum = amount * count;
        winningMoney += sum;
    }
}
