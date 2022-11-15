package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("당첨 횟수 6에 대한 1등 순위 반환 테스트")
    void valueOf_case1() {
        // given
        int matchCount = 6;
        boolean isMatchBonusNumber = false;

        // when
        Rank rank = Rank.valueOf(matchCount, isMatchBonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("당첨 횟수 6에 대한 2등 순위 반환 테스트")
    void valueOf_case2() {
        // given
        int matchCount = 5;
        boolean isMatchBonusNumber = true;

        // when
        Rank rank = Rank.valueOf(matchCount, isMatchBonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("당첨 횟수 6에 대한 3등 순위 반환 테스트")
    void valueOf_case3() {
        // given
        int matchCount = 5;
        boolean isMatchBonusNumber = false;

        // when
        Rank rank = Rank.valueOf(matchCount, isMatchBonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨 횟수 3 미만은 꽝 이므로 LOSE 반환")
    void valueOf_case4() {
        // given
        int matchCount = 2;
        boolean isMatchBonusNumber = false;

        // when
        Rank rank = Rank.valueOf(matchCount, isMatchBonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.LOSE);
    }
}