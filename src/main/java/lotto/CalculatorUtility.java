package lotto;

import java.util.Map;

public class CalculatorUtility {
    public int convertMoneyToTickets(int purchasingAmount) {
        return purchasingAmount / 1000;
    }

    public ProfitRate calculateProfitRate(WinningStatistics winningStatistics, LottoBuyer lottoBuyer) {
        int purchasingAmount = lottoBuyer.getPurchasingAmount();
        ProfitRate profitRate = new ProfitRate(winningStatistics.getTotalProfit() / (double) purchasingAmount * 100);
        return profitRate;
    }
}
