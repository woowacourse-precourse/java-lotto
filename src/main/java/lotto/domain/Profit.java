package lotto.domain;

public class Profit {

    private Double profit;

    public Profit(Lottos lottos, WinningResult winningResult) {
        this.profit = calculateProfit(lottos, winningResult);
    }

    public Double calculateProfit(Lottos lottos, WinningResult winningResult) {
        Double totalPrize = winningResult.calculateTotalPrize();
        return lottos.calculateProfit(totalPrize) * 10;
    }
}
