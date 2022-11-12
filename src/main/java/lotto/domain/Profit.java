package lotto.domain;

public class Profit {
    private WinningTable winningTable;

    public Profit(WinningTable winningTable) {
        this.winningTable = winningTable;
    }

    public int calProfit() {
        int profit = winningTable.getPrice() - BuyLotto.LOTTO_PRICE;
        return profit;
    }
}
