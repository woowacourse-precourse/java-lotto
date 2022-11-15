package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("1등 매칭 테스트.")
    @Test
    void RankMatchPlace1() {
        // given
        int commonMatch = 6;
        boolean bonusMatch = false;

        // when
        Rank rank = Rank.matchOf(commonMatch, bonusMatch);

        // then
        assertThat(rank).isEqualTo(Rank.PLACE_1);
    }

    @DisplayName("2등 매칭 테스트.")
    @Test
    void RankMatchPlace2() {
        // given
        int commonMatch = 5;
        boolean bonusMatch = true;

        // when
        Rank rank = Rank.matchOf(commonMatch, bonusMatch);

        // then
        assertThat(rank).isEqualTo(Rank.PLACE_2);
    }

    @DisplayName("1등 매칭 테스트.")
    @Test
    void RankMatchPlace3() {
        // given
        int commonMatch = 5;
        boolean bonusMatch = false;

        // when
        Rank rank = Rank.matchOf(commonMatch, bonusMatch);

        // then
        assertThat(rank).isEqualTo(Rank.PLACE_3);
    }

    @DisplayName("4등 매칭 테스트.")
    @Test
    void RankMatchPlace4() {
        // given
        int commonMatch = 4;
        boolean bonusMatch = false;

        // when
        Rank rank = Rank.matchOf(commonMatch, bonusMatch);

        // then
        assertThat(rank).isEqualTo(Rank.PLACE_4);
    }

    @DisplayName("5등 매칭 테스트.")
    @Test
    void RankMatchPlace5() {
        // given
        int commonMatch = 3;
        boolean bonusMatch = false;

        // when
        Rank rank = Rank.matchOf(commonMatch, bonusMatch);

        // then
        assertThat(rank).isEqualTo(Rank.PLACE_5);
    }

    @DisplayName("2, 3등이 아닌 경우 bonus는 영향을 받지 않는다.")
    @Test
    void RankMatchNotEffectBonusWhenPlace2Or3() {
        // given
        int commonMatch = 3;
        boolean bonusMatch = true;

        // when
        Rank rank = Rank.matchOf(commonMatch, bonusMatch);

        // then
        assertThat(rank).isEqualTo(Rank.PLACE_5);
    }

    @DisplayName("매칭 정보가 없는 경우 null을 반환한다.")
    @Test
    void RankMatchWhenNotMatchingReturnNull() {
        // given
        int commonMatch = 1;
        boolean bonusMatch = true;

        // when
        Rank rank = Rank.matchOf(commonMatch, bonusMatch);

        // then
        assertThat(rank).isNull();
    }
}