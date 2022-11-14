package lotto.domain;

public class RateOfReturn {
    private static final double ROUNDS = 10.0;

    private double winnings;
    private int money;

    public RateOfReturn(double winnings, int money) {
        this.winnings = winnings;
        this.money = money;
    }

    public double calculate() {
        double percentage = getPercentage();

        return getRounds(percentage);
    }

    private double getRounds(double percentage) {
        return Math.round((percentage * ROUNDS)) / ROUNDS;
    }

    private double getPercentage() {
        return winnings / money * 100;
    }
}
