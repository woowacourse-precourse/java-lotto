package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RankTest {

    @BeforeEach
    void setUp() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rank.initCount());
    }

    @Test
    void count_plus() {
        Rank rank = Rank.FIRST;
        assertThat(rank.getCount()).isEqualTo(0);

        rank.plus();

        assertThat(rank.getCount()).isEqualTo(1);
    }

    @Test
    void find_rank() {
        Rank findRank = Rank.getRank(3);

        assertThat(findRank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void matchNumber_under_three_error() {
        assertThatThrownBy(() -> Rank.getRank(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
