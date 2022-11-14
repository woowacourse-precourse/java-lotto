package domain;

public class LottoStatistics {

    private final String percentageOfProfit;
    private final float PERCENTAGE = 100F;

    public LottoStatistics(int money, int prizeMoney) {
        percentageOfProfit = calculatePercentageOfProfit(money, prizeMoney);
    }

    private String calculatePercentageOfProfit(int money, int prizeMoney) {
        float profit = (Float.valueOf(prizeMoney) / Float.valueOf(money)) * PERCENTAGE;
        return String.format("%.1f", profit);
    }

    public String getPercentageOfProfit() {
        return percentageOfProfit;
    }

}
