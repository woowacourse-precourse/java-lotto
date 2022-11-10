package lotto.model;

import static lotto.model.Constants.LottoStatus.MATCH_FIVE_ADD_BONUS_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_THREE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_SIX_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_UNSATISFIED_PROFIT;

import java.util.Arrays;

enum LottoStatus {
    MATCH_UNSATISFIED(0,MATH_UNSATISFIED_PROFIT),
    MATCH_THREE(3,MATCH_THREE_PROFIT),
    MATCH_FOUR(4,MATCH_FOUR_PROFIT),
    MATCH_FIVE(5,MATCH_FIVE_PROFIT),
    MATCH_FIVE_ADD_BONUS(7,MATCH_FIVE_ADD_BONUS_PROFIT),
    MATCH_SIX(6,MATH_SIX_PROFIT);

    private final int profit;
    private final int value;

    LottoStatus(int value,int profit) {
        this.value = value;
        this.profit = profit;
    }

    public static LottoStatus checkValue(int count) {
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
}
