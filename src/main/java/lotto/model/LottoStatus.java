package lotto.model;

import static lotto.model.LottoStatus.Constants.MATCH_FIVE_ADD_BONUS_DESCRIPTION;
import static lotto.model.LottoStatus.Constants.MATCH_FIVE_ADD_BONUS_PROFIT;
import static lotto.model.LottoStatus.Constants.MATCH_FIVE_ADD_BONUS_VALUE;
import static lotto.model.LottoStatus.Constants.MATCH_FIVE_DESCRIPTION;
import static lotto.model.LottoStatus.Constants.MATCH_FIVE_PROFIT;
import static lotto.model.LottoStatus.Constants.MATCH_FIVE_VALUE;
import static lotto.model.LottoStatus.Constants.MATCH_FOUR_DESCRIPTION;
import static lotto.model.LottoStatus.Constants.MATCH_FOUR_PROFIT;
import static lotto.model.LottoStatus.Constants.MATCH_FOUR_VALUE;
import static lotto.model.LottoStatus.Constants.MATCH_SIX_VALUE;
import static lotto.model.LottoStatus.Constants.MATCH_SIZE_PROFIT_DESCRIPTION;
import static lotto.model.LottoStatus.Constants.MATCH_THREE_PROFIT;
import static lotto.model.LottoStatus.Constants.MATCH_THREE_VALUE;
import static lotto.model.LottoStatus.Constants.MATCH_TREE_DESCRIPTION;
import static lotto.model.LottoStatus.Constants.MATCH_UNSATISFIED_VALUE;
import static lotto.model.LottoStatus.Constants.MATH_SIX_PROFIT;
import static lotto.model.LottoStatus.Constants.MATH_UNSATISFIED_DESCRIPTION;
import static lotto.model.LottoStatus.Constants.MATH_UNSATISFIED_PROFIT;

import java.util.Arrays;

enum LottoStatus {
    MATCH_UNSATISFIED(MATCH_UNSATISFIED_VALUE, MATH_UNSATISFIED_PROFIT, MATH_UNSATISFIED_DESCRIPTION),
    MATCH_THREE(MATCH_THREE_VALUE, MATCH_THREE_PROFIT, MATCH_TREE_DESCRIPTION),
    MATCH_FOUR(MATCH_FOUR_VALUE, MATCH_FOUR_PROFIT, MATCH_FOUR_DESCRIPTION),
    MATCH_FIVE(MATCH_FIVE_VALUE, MATCH_FIVE_PROFIT, MATCH_FIVE_DESCRIPTION),
    MATCH_FIVE_ADD_BONUS(MATCH_FIVE_ADD_BONUS_VALUE, MATCH_FIVE_ADD_BONUS_PROFIT, MATCH_FIVE_ADD_BONUS_DESCRIPTION),
    MATCH_SIX(MATCH_SIX_VALUE, MATH_SIX_PROFIT, MATCH_SIZE_PROFIT_DESCRIPTION);

    private final int profit;
    private final int value;
    private final String description;

    LottoStatus(int value, int profit, String description) {
        this.value = value;
        this.profit = profit;
        this.description = description;
    }

    public static lotto.model.LottoStatus checkValue(int count) {
        return Arrays.stream(values())
                .filter(value -> value.getValue() == count)
                .findFirst().orElse(MATCH_UNSATISFIED);
    }

    public int getProfit() {
        return profit;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }


    public static class Constants {
        public static final int MATH_UNSATISFIED_PROFIT = 0;
        public static final int MATCH_THREE_PROFIT = 5_000;
        public static final int MATCH_FOUR_PROFIT = 50_000;
        public static final int MATCH_FIVE_PROFIT = 1_500_000;
        public static final int MATCH_FIVE_ADD_BONUS_PROFIT = 30_000_000;
        public static final int MATH_SIX_PROFIT = 2_000_000_000;
        public static final String MATH_UNSATISFIED_DESCRIPTION = "일치 수량 부족합니다.";
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

        private Constants() {
        }
    }

}
