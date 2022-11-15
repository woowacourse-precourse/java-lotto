package lotto.domain;

public class Calculate {

    public double calculateRateOfProfit(int buyAmount, int winnings) {
        double division = (double) winnings / buyAmount * 100;
        double round = Math.round(division * 10);
        double profit = round / 10;
        return profit;
    }
}
