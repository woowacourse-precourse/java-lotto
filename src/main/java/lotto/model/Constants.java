package lotto.model;

public class Constants {
    public static class LottoStatus {
        public static final int MATH_UNSATISFIED_PROFIT = 0;
        public static final int MATCH_THREE_PROFIT = 5_000;
        public static final int MATCH_FOUR_PROFIT = 50_000;
        public static final int MATCH_FIVE_PROFIT = 1_500_000;
        public static final int MATCH_FIVE_ADD_BONUS_PROFIT = 30_000_000;
        public static final int MATH_SIX_PROFIT = 2_000_000_000;
        public static final String MATH_UNSATISFIED_DESCRIPTION = "일치 수량 부족";
        public static final String MATCH_TREE_DESCRIPTION = "3개 일치 (5,000원)";
        public static final String MATCH_FOUR_DESCRIPTION = "4개 일치 (50,000원)";
        public static final String MATCH_FIVE_DESCRIPTION = "5개 일치 (1,500,000원)";
        public static final String MATCH_FIVE_ADD_BONUS_DESCRIPTION = "5개 일치, 보너스 볼 일치 (30,000,000원)";
        public static final String MATCH_SIZE_PROFIT_DESCRIPTION = "6개 일치 (2,000,000,000원)";
        public static final int MATCH_UNSATISFIED_VALUE = 0;
        public static final int MATCH_THREE_VALUE = 3;
        public static final int MATCH_FOUR_VALUE = 4;
        public static final int MATCH_FIVE_VALUE = 5;
        public static final int MATCH_FIVE_ADD_BONUS_VALUE = 7;
        public static final int MATCH_SIX_VALUE = 6;
    }

    public static final int MONEY_MIN_UNIT = 1000;
    public static final String NUMBER = "^[1-9][0-9]*$";
}
