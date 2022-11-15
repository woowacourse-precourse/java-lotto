package lotto.domain.prize;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeStatisticsTest {

    @DisplayName("6개의 숫자를 맞췄다면 PrizeStatistics의 FIRST가 1만큼 증가한다")
    @Test
    void incrementFirstOfPrizeStatistics() {
        //given
        Prize prize = new Prize("11,12,25,34,35,42", "7");
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        //when
        prizeStatistics.calculateStatistics(List.of(List.of(11, 12, 25, 34, 35, 42)), prize);
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        //then
        assertThat(statistics.get(PrizeType.FIRST)).isEqualTo(1);
    }

    @DisplayName("5개의 숫자를 맞추고 보너스 번호까지 맞았다면 PrizeStatistics의 SECOND가 1만큼 증가한다")
    @Test
    void incrementSecondOfPrizeStatistics() {
        //given
        Prize prize = new Prize("1,2,3,4,5,6", "7");
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        //when
        prizeStatistics.calculateStatistics(List.of(List.of(1, 2, 3, 4, 5, 7)), prize);
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        //then
        assertThat(statistics.get(PrizeType.SECOND)).isEqualTo(1);
    }

    @DisplayName("5개의 숫자를 맞추고 보너스 번호를 맞추지 못했다면 PrizeStatistics의 THIRD가 1만큼 증가한다")
    @Test
    void incrementThirdOfPrizeStatistics() {
        //given
        Prize prize = new Prize("6,8,9,14,22,35", "40");
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        //when
        prizeStatistics.calculateStatistics(List.of(List.of(1, 6, 8, 9, 14, 35)), prize);
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        //then
        assertThat(statistics.get(PrizeType.THIRD)).isEqualTo(1);
    }

    @DisplayName("4개의 숫자를 맞췄다면 PrizeStatistics의 FOURTH가 1만큼 증가한다")
    @Test
    void incrementFourthOfPrizeStatistics() {
        //given
        Prize prize = new Prize("5,8,9,14,35,40", "41");
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        //when
        prizeStatistics.calculateStatistics(List.of(List.of(1, 6, 8, 9, 14, 35)), prize);
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        //then
        assertThat(statistics.get(PrizeType.FOURTH)).isEqualTo(1);
    }

    @DisplayName("3개의 숫자를 맞췄다면 PrizeStatistics의 FIFTH가 1만큼 증가한다")
    @Test
    void incrementFIFTHOfPrizeStatistics() {
        //given
        Prize prize = new Prize("5,19,21,34,35,43", "25");
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        //when
        prizeStatistics.calculateStatistics(List.of(List.of(5, 6, 8, 19, 21, 39)), prize);
        Map<PrizeType, Integer> statistics = prizeStatistics.getPrizeStatistics();
        //then
        assertThat(statistics.get(PrizeType.FIFTH)).isEqualTo(1);
    }
}