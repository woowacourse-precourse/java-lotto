package domain;

public class Profit {

    private final String percentageProfit;
    private final float PERCENTAGE = 100F;

    public Profit(int money, long prizeMoney) {
        percentageProfit = calculatePercentageProfit(money, prizeMoney);
    }

    private String calculatePercentageProfit(int money, long prizeMoney) {
        float profit = (Float.valueOf(prizeMoney) / Float.valueOf(money)) * PERCENTAGE;
        return String.format("%.1f", profit);
    }

    public String getPercentageProfit() {
        return percentageProfit;
    }

}
