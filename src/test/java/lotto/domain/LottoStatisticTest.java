package lotto.domain;

import lotto.constant.LottoAward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticTest {
    @DisplayName("계산한 수익률을 반환한다.")
    @Test
    void givenAwardCount_whenCalculateReturnOfInvestment_thenReturnROI() {
        //given
        Map<LottoAward, Integer> awardCount = new HashMap<>();
        awardCount.put(LottoAward.FIFTH, 1);
        LottoStatistic statistic = LottoStatistic.of(awardCount);

        //when
        double answer = 62.5;
        double result = statistic.getReturnOnInvestmentRatio(8000);
        result = Math.round((result * 100)) / 100.0;

        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("구매 가능한 티켓수의 최대값에서 수익률을 계산한다.")
    @Test
    void givenMaximumValue_whenCalculateReturnOfInvestment_thenReturnROI() {
        //given
        Map<LottoAward, Integer> awardCount = new HashMap<>();
        awardCount.put(LottoAward.FIRST, Integer.MAX_VALUE / 1000);
        LottoStatistic statistic = LottoStatistic.of(awardCount);

        //when
        double answer = 2.0E8;
        double result = statistic.getReturnOnInvestmentRatio((Integer.MAX_VALUE / 1000) * 1000);
        result = Math.round((result * 100)) / 100.0;

        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("당첨된 로또가 없을 때의 수익률을 계산한다.")
    @Test
    void givenMinimumValue_whenCalculateReturnOfInvestment_thenReturnROI() {
        //given
        Map<LottoAward, Integer> awardCount = new HashMap<>();
        awardCount.put(LottoAward.NONE, Integer.MAX_VALUE / 1000);
        LottoStatistic statistics = LottoStatistic.of(awardCount);

        //when
        double answer = 0.0;
        double result = statistics.getReturnOnInvestmentRatio((Integer.MAX_VALUE / 1000) * 1000);
        result = Math.round((result * 100)) / 100.0;

        //then
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("복권당 몇개가 당첨되었는지 반환한다.")
    @Test
    void givenWinningCountPerAward_whenGetCount_thenReturnWinningCount() {

        //given
        Map<LottoAward, Integer> awardCount = new HashMap<>();
        awardCount.put(LottoAward.FIFTH, 1);
        awardCount.put(LottoAward.FOURTH, 3);
        awardCount.put(LottoAward.SECOND, 4);

        LottoStatistic statistics = LottoStatistic.of(awardCount);

        //when
        int fifthResult = 1;
        int fourthResult = 3;
        int thirdResult = 0;
        int secondResult = 4;
        int firstResult = 0;
        //then
        assertThat(statistics.getWinningCount(LottoAward.FIFTH)).isEqualTo(fifthResult);
        assertThat(statistics.getWinningCount(LottoAward.FOURTH)).isEqualTo(fourthResult);
        assertThat(statistics.getWinningCount(LottoAward.THIRD)).isEqualTo(thirdResult);
        assertThat(statistics.getWinningCount(LottoAward.SECOND)).isEqualTo(secondResult);
        assertThat(statistics.getWinningCount(LottoAward.FIRST)).isEqualTo(firstResult);
    }
}