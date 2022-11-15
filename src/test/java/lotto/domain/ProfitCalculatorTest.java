package lotto.domain;


import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {
    @DisplayName("결과 등수와 구입 금액이 입력되면 수익률 반환.")
    @Test
    void calculateProfitTest() {
        Map<Rank, Integer> resultRank = Map.ofEntries(
                Map.entry(Rank.FIRST_PLACE, 0),
                Map.entry(Rank.SECOND_PLACE, 0),
                Map.entry(Rank.THIRD_PLACE, 0),
                Map.entry(Rank.FOURTH_PLACE, 0),
                Map.entry(Rank.FIFTH_PLACE, 1)
        );
        int purchaseMoney = 8000;
        double expected = 62.5;

        ProfitCalculator profitCalculator = new ProfitCalculator(resultRank, purchaseMoney);

        assertThat(profitCalculator.getProfit()).isEqualTo(expected);
    }
}