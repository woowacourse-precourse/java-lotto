package lotto.domain;

import java.util.*;

public class CalculateReturn {
    private final String returnRate;

    public CalculateReturn(int purchaseCount, LinkedHashMap<String, Integer> winningStats) {
        double sum = 0;
        for (String key : winningStats.keySet()) {
            int winnings = (convertMoneyToNumber(WinInfo.valueOf(key).getWinnings()));
            int count = winningStats.get(key);
            sum += winnings * count;
        }
        double rate = sum / (purchaseCount * 1000) * 100;
        this.returnRate = String.format("%.1f", rate);
    }

    private int convertMoneyToNumber(String money) {
        return Integer.parseInt(money.replaceAll(",", ""));
    }
    public String getReturnRate() {
        return this.returnRate;
    }
}
