package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateProfitRateTest {
    private int principal;
    private Map<String, Integer> totalPrize;

    @BeforeEach
    void testInit() {
        totalPrize = new HashMap<>();
    }

    @Test
    @DisplayName("8000원으로 5등에 당첨 됐을 때 수익률은 62.5 이다.")
    void getProfitRateWhen5thPlace() {
        principal = 8000;
        totalPrize.put(PrizeRank.FIRST.name(), 0);
        totalPrize.put(PrizeRank.SECOND.name(), 0);
        totalPrize.put(PrizeRank.THIRD.name(), 0);
        totalPrize.put(PrizeRank.FOURTH.name(), 0);
        totalPrize.put(PrizeRank.FIFTH.name(), 1);
        CalculateProfitRate calculateProfitRate = new CalculateProfitRate(principal, totalPrize);
        double profitRate = calculateProfitRate.getProfitRate();
        assertThat(profitRate).isEqualTo(62.5);
    }
}