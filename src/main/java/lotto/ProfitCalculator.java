package lotto;

public class ProfitCalculator {

    static public float calculate(int money) {
        float profit = getTotalReward() / money * 100;
        printProfit(profit);
        return profit;
    }

    public static float getTotalReward() {
        float result = 0;
        for(Rank rank : Rank.values()) {
            result += rank.getReward() * rank.getCount();
        }
        return result;
    }

    private static void printProfit(float profit) {
        String profitPercent = String.format("%.lf", profit);
        System.out.println("총 수익률은 " + profitPercent + "%입니다.");
    }

}
