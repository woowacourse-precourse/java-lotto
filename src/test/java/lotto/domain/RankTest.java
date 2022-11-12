package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("1등 당첨")
    void getRankFirstPrize() {
        // given
        int matchCount = 6;
        // when
        Rank resultBonusMatch = Rank.getRank(matchCount, true);
        Rank resultBonusMismatch = Rank.getRank(matchCount, true);
        // then
        Assertions.assertThat(resultBonusMatch).isEqualTo(Rank.FIRST);
        Assertions.assertThat(resultBonusMismatch).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 당첨")
    void getRankSecondPrize() {
        // given
        int matchCount = 5;
        // when
        Rank result = Rank.getRank(matchCount, true);
        // then
        Assertions.assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등 당첨")
    void getRankThirdPrize() {
        // given
        int matchCount = 5;
        // when
        Rank result = Rank.getRank(matchCount, false);
        // then
        Assertions.assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등 당첨")
    void getRankFourthPrize() {
        // given
        int matchCount = 4;
        // when
        Rank resultBonusMatch = Rank.getRank(matchCount, true);
        Rank resultBonusMismatch = Rank.getRank(matchCount, true);
        // then
        Assertions.assertThat(resultBonusMatch).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(resultBonusMismatch).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("5등 당첨")
    void getRankFifthPrize() {
        // given
        int matchCount = 3;
        // when
        Rank resultBonusMatch = Rank.getRank(matchCount, true);
        Rank resultBonusMismatch = Rank.getRank(matchCount, true);
        // then
        Assertions.assertThat(resultBonusMatch).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(resultBonusMismatch).isEqualTo(Rank.FIFTH);
    }
}