package lotto.domain.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("1등 테스트")
    @Test
    void firstRank() {
        Rank rank = Rank.getRank(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등 테스트")
    @Test
    void secondRank() {
        Rank rank = Rank.getRank(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등 테스트")
    @Test
    void thirdRank() {
        Rank rank = Rank.getRank(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4등 테스트 보너스 X")
    @Test
    void fourthRank() {
        Rank rank = Rank.getRank(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("4등 테스트 보너스 O")
    @Test
    void fourthRank2() {
        Rank rank = Rank.getRank(4, true);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("5등 테스트 보너스 X")
    @Test
    void fifthRank() {
        Rank rank = Rank.getRank(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("5등 테스트 보너스 O")
    @Test
    void fifthRank2() {
        Rank rank = Rank.getRank(3, true);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("꽝 테스트 보너스 X")
    @Test
    void failRank() {
        Rank rank1 = Rank.getRank(2, false);
        Rank rank2 = Rank.getRank(1, false);
        Rank rank3 = Rank.getRank(0, false);

        assertAll(
                () -> assertThat(rank1).isEqualTo(Rank.FAIL),
                () -> assertThat(rank2).isEqualTo(Rank.FAIL),
                () -> assertThat(rank3).isEqualTo(Rank.FAIL)
        );
    }

    @DisplayName("꽝 테스트 보너스 O")
    @Test
    void failRank2() {
        Rank rank = Rank.getRank(2, true);

        assertThat(rank).isEqualTo(Rank.FAIL);
    }
}