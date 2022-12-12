package lotto.domain;

public class Profit {
    private final double profit;

    public Profit(LottoTicketsResult results, Money money) {
        this.profit = calculate(results, money);
    }

    private double calculate(LottoTicketsResult results, Money money) {
        int winningAmount = results.getWinningAmountSum();
        return (winningAmount / (double) money.getMoney()) * 100;
    }

    public double getProfit() {
        return profit;
    }
}
