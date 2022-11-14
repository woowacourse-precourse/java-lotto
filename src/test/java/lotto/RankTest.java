package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @BeforeEach
    void setUp() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rank.initCount());
    }

    @Test
    void 카운트_플러스() {
        Rank rank = Rank.ONE;
        assertThat(rank.getCount()).isEqualTo(0);

        rank.plus();

        assertThat(rank.getCount()).isEqualTo(1);
    }

    @Test
    void 일치하는_숫자_개수로_랭크_찾기() {
        Rank findRank = Rank.getRank(3);

        assertThat(findRank).isEqualTo(Rank.FIVE);
    }

    @Test
    void 일치하는_숫자_개수가_3개_이하면_오류() {
        assertThatThrownBy(() -> Rank.getRank(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}