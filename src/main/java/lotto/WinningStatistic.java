package lotto;

import constants.LottoConstants;
import user.PurchaseAmount;

import java.util.Arrays;
import java.util.Map;

public class WinningStatistic {

    private final Map<Wins, Integer> winningResult;

    public WinningStatistic(Map<Wins, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public Map<Wins, Integer> getWinningResult() {
        return winningResult;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        long sumOfWinnings = Arrays.stream(Wins.values())
                .mapToLong(win -> win.getWinnings() * winningResult.get(win))
                .sum();

        double profitRate = (double) sumOfWinnings / purchaseAmount.getPurchaseAmount();

        return profitRate * LottoConstants.PERCENTAGE_UNIT;
    }
}
