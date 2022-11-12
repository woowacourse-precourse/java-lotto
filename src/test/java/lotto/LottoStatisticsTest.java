package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatisticsTest {

    @DisplayName("결과를 추가하지 않았을 때 수익률 조회 시 예외 처리.")
    @Test
    void resultByNeverAdded() {
        LottoStatistics statistics = new LottoStatistics();

        assertThatThrownBy(() -> statistics.getYield())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1건의 로또결과에 대한 수익률 비교.")
    @Test
    void resultByOneRankAdded() {
        LottoStatistics statistics = new LottoStatistics();
        statistics.add(LottoRank.SECOND);

        assertThat(statistics.getYield()).isEqualTo(3000000);
    }

    @DisplayName("2건의 로또결과에 대한 수익률 비교.")
    @Test
    void resultByTwoRankAdded() {
        LottoStatistics statistics = new LottoStatistics();
        statistics.add(LottoRank.FOURTH);
        statistics.add(LottoRank.LOSE);

        assertThat(statistics.getYield()).isEqualTo(2500);
    }

    @DisplayName("4건의 낙첨과 1건의 3등에 대한 수익률 비교.")
    @Test
    void resultByManyRankAdded() {
        LottoStatistics statistics = new LottoStatistics();
        List<LottoRank> ranks = List.of(LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE,
                LottoRank.THIRD, LottoRank.LOSE);
        for (LottoRank rank : ranks) {
            statistics.add(rank);
        }

        assertThat(statistics.getYield()).isEqualTo(30000);
    }

    @DisplayName("모두 낙첨되었을 때에 대한 수익률 비교.")
    @Test
    void resultByOnlyLose() {
        LottoStatistics statistics = new LottoStatistics();
        List<LottoRank> ranks = List.of(LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE);
        for (LottoRank rank : ranks) {
            statistics.add(rank);
        }

        assertThat(statistics.getYield()).isEqualTo(0);
    }
}
