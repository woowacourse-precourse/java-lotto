package lotto.model;

public class Constants {
    public static class LottoStatus {
        public static final int MATH_UNSATISFIED_PROFIT = 0;
        public static final int MATCH_THREE_PROFIT = 5_000;
        public static final int MATCH_FOUR_PROFIT = 50_000;
        public static final int MATCH_FIVE_PROFIT = 1_500_000;
        public static final int MATCH_FIVE_ADD_BONUS_PROFIT = 30_000_000;
        public static final int MATH_SIX_PROFIT = 2_000_000_000;
    }

    public static final int MONEY_MIN_UNIT = 1000;
}
