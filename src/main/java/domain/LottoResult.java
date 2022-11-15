package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Integer> lottoStatistics;
    private final int money;
    private int winningMoney = 0;
    private String winningOutput = "";
    private static final Map<Integer, Integer> winningAmount;
    static {
        winningAmount = new HashMap<>();
        winningAmount.put(0, 5000);
        winningAmount.put(1, 50000);
        winningAmount.put(2, 1500000);
        winningAmount.put(3, 30000000);
        winningAmount.put(4, 2000000000);
    }
    private static final Map<Integer,String> resultView;
    static {
        resultView = new HashMap<>();
        resultView.put(0, "3개 일치 (5,000원) - ");
        resultView.put(1, "4개 일치 (50,000원) - ");
        resultView.put(2, "5개 일치 (1,500,000원) - ");
        resultView.put(3, "5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        resultView.put(4, "6개 일치 (2,000,000,000원) - ");
    }

    public LottoResult(List<Integer> lottoStatistics, int money) {
        this.lottoStatistics = lottoStatistics;
        this.money = money;
    }

    public String getWinningResult() {
        for (int i = 0; i < 5; i++) {
            int number = lottoStatistics.get(i);
            addAmount(winningAmount.get(i),number);
            addOutput(resultView.get(i),number);
        }

    }

    private void addAmount(int amount, int count) {
        int sum = amount * count;
        winningMoney += sum;
    }

    private void addOutput(String phrase, int count) {
        String addingPhrase = phrase + changeType(count) + "개\n";
        winningOutput += addingPhrase;
    }

    private String changeType(int count) {
        return Integer.toString(count);
    }
}
