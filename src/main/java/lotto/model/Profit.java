package lotto.model;

public class Profit {
    private double profit = 0;

    public Profit(int money, long prize) {
        setProfit(money, prize);
    }
    private void setProfit(int money, long prize) {
        profit = (double) prize/money;
    }
    public double getProfit() {
        return profit;
    }
}
