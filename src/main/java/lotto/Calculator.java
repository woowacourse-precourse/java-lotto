package lotto;

public class Calculator {
    public static final int SIX_MATCH_REWARD = 2000000000;
    public static final int FIVE_BONUS_MATCH_REWARD = 30000000;
    public static final int FIVE_MATCH_REWARD = 1500000;
    public static final int FOUR_MATCH_REWARD = 50000;
    public static final int THREE_MATCH_REWARD = 5000;
    static double priceAmount = 0;

    public static double rateOfReturn(int purchaseAmount) {
        return Math.round(priceAmount / purchaseAmount * 1000.0) / 10.0;
    }

    public static void addPrize() {
        if (Compare.compareLotto.get(3) != null) {
            priceAmount = Compare.compareLotto.get(3) * THREE_MATCH_REWARD;
        }
        if (Compare.compareLotto.get(4) != null) {
            priceAmount = Compare.compareLotto.get(4) * FOUR_MATCH_REWARD;
        }
        if (Compare.compareLotto.get(5) != null) {
            priceAmount = Compare.compareLotto.get(5) * FIVE_MATCH_REWARD;
        }
        if (Compare.compareLotto.get(6) != null) {
            priceAmount = Compare.compareLotto.get(6) * FIVE_BONUS_MATCH_REWARD;
        }
        if (Compare.compareLotto.get(7) != null) {
            priceAmount = Compare.compareLotto.get(7) * SIX_MATCH_REWARD;
        }
    }

    public static int convertNull(Integer integer) {
        if (integer == null) {
            return 0;
        }
        return integer;
    }

}
