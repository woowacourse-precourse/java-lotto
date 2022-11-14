package lotto.domain;

public class Profit {
    public static double calculateRate(int purchaseAmount, int prizeMoney) {
        double rate = ((double) prizeMoney / (double) purchaseAmount) * 100;
        return Math.round(rate * 10) / 10.0;
    }

    public static void showRate(int purchaseAmount, int prizeMoney) {
        String profitRate = String.valueOf(calculateRate(purchaseAmount, prizeMoney));
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
