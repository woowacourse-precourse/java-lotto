package lotto.domain;

public class MatchConst {
    public class MatchCount {
        public static final int SIX_MATCH = 6;
        public static final int FIVE_MATCH_PLUS_BONUS = 5;
        public static final int FIVE_MATCH = 5;
        public static final int FOUR_MATCH = 4;
        public static final int THREE_MATCH = 3;
    }

    public class MatchProfit {
        public static final int SIX_MATCH_PROFIT = 2000000000;
        public static final int FIVE_MATCH_PLUS_BONUS_PROFIT = 30000000;
        public static final int FIVE_MATCH_PROFIT = 1500000;
        public static final int FOUR_MATCH_PROFIT = 50000;
        public static final int THREE_MATCH_PROFIT = 5000;
    }

    public class MatchMessage {
        public static final String SIX_MATCHES_MSG = "6개 일치";
        public static final String FIVE_MATCHES_PLUS_BONUS_MSG = "5개 일치, 보너스 볼 일치";
        public static final String FIVE_MATCHES_MSG = "5개 일치";
        public static final String FOUR_MATCHES_MSG = "4개 일치";
        public static final String THREE_MATCHES_MSG = "3개 일치";
    }
}
