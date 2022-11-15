package lotto.model;

public class Calculator {
    private static final int SIX_MATCH_REWARD = 2000000000;
    private static final int FIVE_BONUS_MATCH_REWARD = 30000000;
    private static final int FIVE_MATCH_REWARD = 1500000;
    private static final int FOUR_MATCH_REWARD = 50000;
    private static final int THREE_MATCH_REWARD = 5000;
    private static final int DIVIDE_NUMBER = 1000;
    private static double priceAmount = 0;

    public static int calculatePurchase(int purchaseAmount) {
        return purchaseAmount / DIVIDE_NUMBER;
    }

    public static double rateOfReturn(int purchaseAmount) {
        return Math.round(priceAmount / purchaseAmount * 1000.0) / 10.0;
    }

    public static void addPrize() {
        if (Comparison.compareLotto.get(3) != null) {
            priceAmount = Comparison.compareLotto.get(3) * THREE_MATCH_REWARD;
        }
        if (Comparison.compareLotto.get(4) != null) {
            priceAmount = Comparison.compareLotto.get(4) * FOUR_MATCH_REWARD;
        }
        if (Comparison.compareLotto.get(5) != null) {
            priceAmount = Comparison.compareLotto.get(5) * FIVE_MATCH_REWARD;
        }
        if (Comparison.compareLotto.get(6) != null) {
            priceAmount = Comparison.compareLotto.get(6) * FIVE_BONUS_MATCH_REWARD;
        }
        if (Comparison.compareLotto.get(7) != null) {
            priceAmount = Comparison.compareLotto.get(7) * SIX_MATCH_REWARD;
        }
    }

    public static int convertNull(Integer integer) {
        if (integer == null) {
            return 0;
        }
        return integer;
    }

}
