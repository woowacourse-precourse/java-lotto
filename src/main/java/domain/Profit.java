package domain;

import util.Constant;

public class Profit {

    private final String percentageProfit;
    private final float PERCENTAGE = 100F;

    public Profit(int money, long prizeMoney) {
        percentageProfit = calculatePercentageProfit(money, prizeMoney);
    }

    private String calculatePercentageProfit(int money, long prizeMoney) {
        float profit = (Float.valueOf(prizeMoney) / Float.valueOf(money)) * PERCENTAGE;
        return String.format(Constant.FIRST_DECIMAL_PLACE, profit);
    }

    public String getPercentageProfit() {
        return percentageProfit;
    }

}
