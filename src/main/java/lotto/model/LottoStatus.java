package lotto.model;

import static lotto.model.Constants.LottoStatus.MATCH_FIVE_ADD_BONUS_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_THREE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_SIX_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_UNSATISFIED_PROFIT;

import java.util.Arrays;

enum LottoStatus {
    MATCH_UNSATISFIED(0,MATH_UNSATISFIED_PROFIT,"일치 수량 부족"),
    MATCH_THREE(3,MATCH_THREE_PROFIT,"3개 일치 (5,000원)"),
    MATCH_FOUR(4,MATCH_FOUR_PROFIT,"4개 일치 (50,000원)"),
    MATCH_FIVE(5,MATCH_FIVE_PROFIT,"5개 일치 (1,500,000원)"),
    MATCH_FIVE_ADD_BONUS(7,MATCH_FIVE_ADD_BONUS_PROFIT,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_SIX(6,MATH_SIX_PROFIT,"6개 일치 (2,000,000,000원)");

    private final int profit;
    private final int value;
    private final String description;

    LottoStatus(int value,int profit,String description) {
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
