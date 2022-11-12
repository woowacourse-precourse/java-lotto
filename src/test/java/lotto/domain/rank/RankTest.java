package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "{0}개의 번호가 일치하면 RANK는 {1}이다")
    @CsvSource({
            "6, FIRST",
            "5, THIRD",
            "4, FOURTH",
            "3, FIFTH",
            "2, UNWINNABLE",
            "1, UNWINNABLE",
            "0, UNWINNABLE"
    })
    void judgementRankByMatchNumberCount(final int matchCount, final String rank) {
        assertThat(Rank.matchRank(matchCount, false))
                .isEqualTo(Rank.valueOf(rank));
    }
    @Test
    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하면 2등이다.")
    void fiveMatchNumberAndBonusMatchIsSecond() {
        // given
        final int matchCount = 5;
        final boolean matchBonus = true;

        // when, then
        assertThat(Rank.matchRank(matchCount, matchBonus))
                .isEqualTo(Rank.SECOND);
    }
}