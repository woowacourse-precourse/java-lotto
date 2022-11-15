package lotto.domain;

import lotto.utils.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수익률 계산 테스트")
class RankingCountTest {
    RankingCount rankingCount = new RankingCount();

    @BeforeEach
    void setUp() {
        rankingCount.plusRankingCount(Ranking._5TH.name());
        rankingCount.plusRankingCount(Ranking._4TH.name());
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateYieldTest() {
        double yield = rankingCount.calculateYield(10000);
        Assertions.assertThat(yield).isEqualTo(550);
    }

    @Test
    @DisplayName("반올림 할 경우 수익률 계산 테스트")
    void calculateRoundYieldTest() {
        double yield = rankingCount.calculateYield(7000);
        Assertions.assertThat(yield).isEqualTo(785.7);
    }

    @Test
    @DisplayName("반올림 안할 경우 수익률 계산 테스트")
    void calculateNotRoundYieldTest() {
        double yield = rankingCount.calculateYield(6000);
        Assertions.assertThat(yield).isEqualTo(916.7);
    }

    @Test
    @DisplayName("수익률이 매우 큰 경우")
    void calculateBigYieldTest() {
        rankingCount.plusRankingCount(Ranking._1ST.name());
        double yield = rankingCount.calculateYield(7000);
        Assertions.assertThat(yield).isEqualTo(28572214.3);
    }

    @Test
    @DisplayName("총 상금 40억에 대한 수익률 테스트")
    void overflowTest() {
        rankingCount.plusRankingCount(Ranking._1ST.name());
        rankingCount.plusRankingCount(Ranking._1ST.name());
        double yield = rankingCount.calculateYield(7000);
        Assertions.assertThat(yield).isEqualTo(57143642.9);
    }
}