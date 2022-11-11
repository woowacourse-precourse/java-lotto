package lotto.util;

import lotto.domain.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @Test
    @DisplayName(value = "총 수익 테스트")
    void totalProfitTest() {
        Map<WinningRank, Integer> winLottoCount = new HashMap<>();
        winLottoCount.put(WinningRank.THIRD_RANK, 1);
        winLottoCount.put(WinningRank.FIFTH_RANK, 3);

        int actualTotalProfit = ProfitCalculator.calculateTotalProfit(winLottoCount);
        int expectedTotalProfit = 1_515_000;

        assertThat(actualTotalProfit).isEqualTo(expectedTotalProfit);
    }

    @ParameterizedTest(name = "수익률 테스트 {index} : {2}%")
    @CsvSource(value = {"15_000,70_000,21.4", "87_000,7_000,1242.9"})
    void profitRateTest(int profit, int purchaseAmount, double expectedProfitRate) {
        double actualProfitRate = ProfitCalculator.calculateProfitRate(profit, purchaseAmount);
        assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
    }

}