package lotto.domain;

public class Profit {

    public static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final double PERCENT_NUMBER = 10.0;

    private Double profit;

    public Profit(Lottos lottos, WinningResult winningResult) {
        this.profit = calculateProfit(lottos, winningResult);
    }

    public Double calculateProfit(Lottos lottos, WinningResult winningResult) {
        Double totalPrize = winningResult.calculateTotalPrize();
        return lottos.calculateProfit(totalPrize) * 10.0;
    }

    @Override
    public String toString() {
        return String.format(PROFIT_MESSAGE, (double) Math.round(profit) / PERCENT_NUMBER);
    }
}
