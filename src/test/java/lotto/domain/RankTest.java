package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void FIRST_테스트() {
        Rank rank = Rank.of(6, true);
        assertThat(rank).isEqualTo(rank.FIRST);
    }

    @Test
    void SECOND_테스트() {
        Rank rank = Rank.of(5, true);
        assertThat(rank).isEqualTo(rank.SECOND);
    }

    @Test
    void THIRD_테스트() {
        Rank rank = Rank.of(5, false);
        assertThat(rank).isEqualTo(rank.THIRD);
    }

    @Test
    void FOURTH_테스트() {
        Rank rank = Rank.of(4, false);
        assertThat(rank).isEqualTo(rank.FOURTH);
    }

    @Test
    void FIFTH_테스트() {
        Rank rank = Rank.of(3, false);
        assertThat(rank).isEqualTo(rank.FIFTH);
    }

    @Test
    void NOTHING_테스트() {
        Rank rank = Rank.of(0, false);
        assertThat(rank).isEqualTo(rank.NOTHING);
    }
}
