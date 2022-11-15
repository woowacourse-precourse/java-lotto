package lotto.domain.earning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.prize.PrizeStatistics;
import lotto.domain.prize.PrizeType;

class EarningTest {

    @DisplayName("구입금액이 8000원이고 5등에 당첨됐다면 수익률이 62.5%이다.")
    @Test
    void calculateEarningWhenGivenPurchase8000AndFifth() {
        //given
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        statistics.put(PrizeType.FIFTH, 1);
        //when
        Earning earning = new Earning(8000, statistics);
        //then
        assertThat(String.format("%.1f", earning.getEarning())).isEqualTo("62.5");
    }

    @DisplayName("구입금액이 10000원이고 4등에 당첨됐다면 수익률이 500.0%이다.")
    @Test
    void calculateEarningWhenGivenPurchase10000AndFourth() {
        //given
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        statistics.put(PrizeType.FOURTH, 1);
        //when
        Earning earning = new Earning(10000, statistics);
        //then
        assertThat(String.format("%.1f", earning.getEarning())).isEqualTo("500.0");
    }

    @DisplayName("구입금액이 15000원이고 4등 1개, 5등 1개 당첨됐다면 수익률이 366.7%이다.")
    @Test
    void calculateEarningWhenGivenPurchase15000AndFourthAndFifth() {
        //given
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        statistics.put(PrizeType.FOURTH, 1);
        statistics.put(PrizeType.FIFTH, 1);
        //when
        Earning earning = new Earning(15000, statistics);
        //then
        assertThat(String.format("%.1f", earning.getEarning())).isEqualTo("366.7");
    }

    @DisplayName("구입금액이 4000원이고 3등 1개, 5등 1개 당첨됐다면 수익률이 37625.0%이다.")
    @Test
    void calculateEarningWhenGivenPurchase4000AndThirdAndFifth() {
        //given
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        statistics.put(PrizeType.THIRD, 1);
        statistics.put(PrizeType.FIFTH, 1);
        //when
        Earning earning = new Earning(4000, statistics);
        //then
        assertThat(String.format("%.1f", earning.getEarning())).isEqualTo("37625.0");
    }

    @DisplayName("구입금액이 8,500,000원이고 1등 1개, 5등 3개 당첨됐다면 수익률이 23529.6%이다.")
    @Test
    void calculateEarningWhenGivenPurchase850000AndFirstAndFifth3() {
        //given
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        statistics.put(PrizeType.FIRST, 1);
        statistics.put(PrizeType.FIFTH, 3);
        //when
        Earning earning = new Earning(8500000, statistics);
        //then
        assertThat(String.format("%.1f", earning.getEarning())).isEqualTo("23529.6");
    }
}