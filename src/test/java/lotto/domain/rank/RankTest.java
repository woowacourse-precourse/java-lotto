package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "{0}의 상금은 {1}원이다.")
    @CsvSource({
            "FIRST, 2_000_000_000",
            "SECOND, 30_000_000",
            "THIRD, 1_500_000",
            "FOURTH, 50_000",
            "FIFTH, 5_000",
            "UNWINNABLE, 0",
    })
    void rankAndRewardTest(final String rank, final int reward) {
        // when, then
        assertThat(reward)
                .isEqualTo(Rank.valueOf(rank).getReward().value());
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

    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하면 2등이다.")
    @Test
    void fiveMatchNumberAndBonusMatchIsSecond() {
        // given
        final int matchCount = 5;
        final boolean matchBonus = true;

        // when, then
        assertThat(Rank.matchRank(matchCount, matchBonus))
                .isEqualTo(Rank.SECOND);
    }
}
