package lotto.util;

import lotto.domain.WinningRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @ParameterizedTest(name = "총 수익 계산 테스트 [{index}] : {6} 원")
    @CsvSource(value = {"5,4,0,1,0,0,1_520_000", "0,4,2,3,1,1,2_034_620_000","0,3,0,1,0,2,4_001_515_000"})
    void totalProfitTest(int nonRankedNum, int fifthRankNum, int fourthRankNum, int thirdRankNum, int secondRankNum,
                         int firstRankNum, long expectedTotalProfit) {

        List<Integer> rankedNumbers =
                List.of(nonRankedNum, fifthRankNum, fourthRankNum, thirdRankNum, secondRankNum, firstRankNum);

        Map<WinningRank, Integer> winLottoCount = new HashMap<>();
        int index = 0;
        for(WinningRank rank : WinningRank.values()){
            winLottoCount.put(rank, rankedNumbers.get(index));
            index++;
        }

        long actualTotalProfit = (long) ProfitCalculator.calculateTotalProfit(winLottoCount);

        assertThat(actualTotalProfit).isEqualTo(expectedTotalProfit);
    }

    @ParameterizedTest(name = "수익률 계산 테스트 [{index}] : {2}%")
    @CsvSource(value = {"15_000,70_000,21.4", "87_000,7_000,1242.9"})
    void profitRateTest(long profit, int purchaseAmount, double expectedProfitRate) {
        double actualProfitRate = ProfitCalculator.calculateProfitRate(profit, purchaseAmount);
        assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
    }

}