package lotto.domain;

public class ProfitManager {
    private final int noEarning = 0;

    public int calculateEarning(LottoRank lottoRank) {
        if (lottoRank.getWinningCount() != 0) {
            return (lottoRank.getWinningPrice() * lottoRank.getWinningCount());
        }
        return noEarning;
    }


    public double calculateProfit(int purchaseAmount, int totalEarning) {
        double totalProfit;
        totalProfit = ((double) totalEarning / (double) purchaseAmount);
        return totalProfit;
    }
}
