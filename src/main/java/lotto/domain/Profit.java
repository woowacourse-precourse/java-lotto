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

    @Override
    public String toString() {
        return String.format("총 수익률은 %.1f%%입니다.", (double) Math.round(profit) / 10.0);
    }
}
