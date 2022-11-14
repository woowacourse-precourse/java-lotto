package lotto.domain;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 미당첨확인() {
        Rank rank = Rank.calculateRank(0, false);
        assertThat(rank).isEqualTo(null);
    }

    @Test
    void 오등확인() {
        Rank rank = Rank.calculateRank(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 삼등확인() {
        Rank rank = Rank.calculateRank(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 이등확인() {
        Rank rank = Rank.calculateRank(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 일등확인() {
        Rank rank = Rank.calculateRank(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
