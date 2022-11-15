package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @Test
    void _1등일_때() {
        Rank rank = Rank.get(6, false);
        Assertions.assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void _2등일_때() {
        Rank rank = Rank.get(5, true);
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void _3등일_때() {
        Rank rank = Rank.get(5, false);
        Assertions.assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void _4등일_때() {
        Rank rank = Rank.get(4, false);
        Assertions.assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void _5등일_때() {
        Rank rank = Rank.get(3, false);
        Assertions.assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void _6등일_때(int matchCount) {
        Rank rank = Rank.get(matchCount, false);
        Assertions.assertThat(rank).isEqualTo(Rank.LOSE);
    }
}