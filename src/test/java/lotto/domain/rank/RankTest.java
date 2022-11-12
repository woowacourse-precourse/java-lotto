package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("1등 상금은 2,000,000,000 원이다.")
    void firstPlaceRewardIs2_000_000_000Won() {
        // given
        final int reward = 2_000_000_000;

        // when, then
        assertThat(Rank.FIRST.getReward())
                .isEqualTo(reward);
    }

    @Test
    @DisplayName("2등 상금은 30,000,000 원이다.")
    void secondPlaceRewardIs30_000_000Won() {
        // given
        final int reward = 30_000_000;

        // when, then
        assertThat(Rank.SECOND.getReward())
                .isEqualTo(reward);
    }

    @Test
    @DisplayName("3등 상금은 1,500,000 원이다.")
    void thirdPlaceRewardIs1_500_000Won() {
        // given
        final int reward = 1_500_000;

        // when, then
        assertThat(Rank.THIRD.getReward())
                .isEqualTo(reward);
    }

    @Test
    @DisplayName("4등 상금은 50,000 원이다.")
    void fourthPlaceRewardIs2_000_000_000Won() {
        // given
        final int reward = 50_000;

        // when, then
        assertThat(Rank.FOURTH.getReward())
                .isEqualTo(reward);
    }

    @Test
    @DisplayName("5등 상금은 5,000 원이다.")
    void fifthPlaceRewardIs2_000_000_000Won() {
        // given
        final int reward = 5_000;

        // when, then
        assertThat(Rank.FIFTH.getReward())
                .isEqualTo(reward);
    }

    @Test
    @DisplayName("당첨되지 않으면 상금은 없다")
    void noneRewardIs0() {
        // given
        final int reward = 0;

        // when, then
        assertThat(Rank.UNWINNABLE.getReward())
                .isEqualTo(reward);
    }
}