package lotto.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void getRankMiss() {
        assertThat(Rank.getRank(1, true)).isEqualTo(Rank.MISS);
    }

    @Test
    void getRankThree() {
        assertThat(Rank.getRank(3, true)).isEqualTo(Rank.WIN_THREE);
    }

    @Test
    void getRankFour() {
        assertThat(Rank.getRank(4, true)).isEqualTo(Rank.WIN_FOUR);
    }

    @Test
    void getRankFiveWithBonus() {
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.WIN_FIVE_WITH_BONUS);
    }

    @Test
    void getRankFiveWithoutBonus() {
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.WIN_FIVE);
    }

    @Test
    void getRankSix() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.WIN_SIX);
    }
}