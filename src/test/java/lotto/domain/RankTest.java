package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void of_1등() {
        Rank rank = Rank.of(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void of_2등() {
        Rank rank = Rank.of(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void of_3등() {
        Rank rank = Rank.of(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void of_4등() {
        Rank rank = Rank.of(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void of_5등() {
        Rank rank = Rank.of(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void of_loser() {
        Rank rank = Rank.of(1, false);

        assertThat(rank).isEqualTo(Rank.LOSER);
    }
}