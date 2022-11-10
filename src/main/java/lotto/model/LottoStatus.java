package lotto.model;

import static lotto.model.Constants.LottoStatus.MATCH_FIVE_ADD_BONUS_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_THREE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_SIX_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_UNSATISFIED_PROFIT;

enum LottoStatus {
    MATCH_UNSATISFIED(MATH_UNSATISFIED_PROFIT),
    MATCH_THREE(MATCH_THREE_PROFIT),
    MATCH_FOUR(MATCH_FOUR_PROFIT),
    MATCH_FIVE(MATCH_FIVE_PROFIT),
    MATCH_FIVE_ADD_BONUS(MATCH_FIVE_ADD_BONUS_PROFIT),
    MATCH_SIX(MATH_SIX_PROFIT);

    private final int profit;

    LottoStatus(int profit) {
        this.profit = profit;
    }

    public int getProfit() {
        return profit;
    }


}
