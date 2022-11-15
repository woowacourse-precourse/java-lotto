package lotto.domain;

public class EarningRate {

    private final double percent;

    public EarningRate(double percent) {
        this.percent = percent;
    }

    public static EarningRate calculateRateOfProfit(int reward, Amounts amounts) {
        return new EarningRate(((double) reward / amounts.getMoney()) * 100);
    }

    public double getPercent() {
        return percent;
    }

}
