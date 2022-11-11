package lotto.model;

import static lotto.model.Constants.LottoStatus.MATCH_FIVE_ADD_BONUS_DESCRIPTION;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_ADD_BONUS_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_ADD_BONUS_VALUE;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_DESCRIPTION;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_VALUE;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_DESCRIPTION;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_VALUE;
import static lotto.model.Constants.LottoStatus.MATCH_SIX_VALUE;
import static lotto.model.Constants.LottoStatus.MATCH_SIZE_PROFIT_DESCRIPTION;
import static lotto.model.Constants.LottoStatus.MATCH_THREE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_THREE_VALUE;
import static lotto.model.Constants.LottoStatus.MATCH_TREE_DESCRIPTION;
import static lotto.model.Constants.LottoStatus.MATCH_UNSATISFIED_VALUE;
import static lotto.model.Constants.LottoStatus.MATH_SIX_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_UNSATISFIED_DESCRIPTION;
import static lotto.model.Constants.LottoStatus.MATH_UNSATISFIED_PROFIT;

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

    public String getDescription() {
        return description;
    }

}
