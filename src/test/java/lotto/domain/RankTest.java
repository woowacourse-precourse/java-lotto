package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("6개 번호가 일치하면 1등이다.")
    @Test
    void findRank1st() {
        Rank rank = Rank.findRank(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 일치하면 2등이다.")
    @Test
    void findRank2nd() {
        Rank rank = Rank.findRank(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호가 불일치하면 3등이다.")
    @Test
    void findRank3rd() {
        Rank rank = Rank.findRank(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 번호가 일치하면 4등이다.")
    @Test
    void findRank4th() {
        Rank rank = Rank.findRank(4, true);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 번호가 일치하면 5등이다.")
    @Test
    void findRank5th() {
        Rank rank = Rank.findRank(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("일치하는 번호가 3개 미만이면 꽝이다.")
    @Test
    void findRankBang() {
        Rank rank = Rank.findRank(2, true);

        assertThat(rank).isEqualTo(Rank.BANG);
    }
}