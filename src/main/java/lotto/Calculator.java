package lotto;

public class Calculator {
    private int[] winningCost = new int[]{5_000, 50_000, 1_500_000, 2_000_000_000, 30_000_000};
    public int getProfit(int[] winningArray) {
        int result = 0;
        for (int i = 0; i <winningArray.length ; i++) {
            result += winningArray[i] * winningCost[i];
        }
        return result;
    }
    public double getEarningsRate(int purchaseCost, int [] winningArray) {
        return Math.round((getProfit(winningArray) / purchaseCost) * 10000) /100.0;
    }
}
