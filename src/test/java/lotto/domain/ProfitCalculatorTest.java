package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {

    @DisplayName("결과 등수와 구입 금액이 들어오면 수익률을 반환한다.")
    @Test
    void calculateProfitTest() {
        Map<Rank, Integer> resultRank = Map.ofEntries(
                Map.entry(Rank.FIRST, 0),
                Map.entry(Rank.SECOND, 0),
                Map.entry(Rank.THIRD, 0),
                Map.entry(Rank.FOURTH, 0),
                Map.entry(Rank.FIFTH, 1)
        );
        int purchaseMoney = 8000;
        double expected = 62.5;

        ProfitCalculator profitCalculator = new ProfitCalculator(resultRank, purchaseMoney);

        assertThat(profitCalculator.getProfit()).isEqualTo(expected);
    }
}
