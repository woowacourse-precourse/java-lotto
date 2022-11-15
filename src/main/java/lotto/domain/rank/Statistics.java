package lotto.domain.rank;


public class Statistics {

    private static final int PERCENTAGE = 100;

    private int winAmount;

    public double findLottoYield(int purchaseAmount) {
        double quotient = (double) winAmount / (double) purchaseAmount;
        return quotient * PERCENTAGE;
    }
}
