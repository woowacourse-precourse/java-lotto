package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("6개 숫자가 일치할 경우 1등이다.")
    @Test
    void firstRankTest() {
        Rank rank = Rank.findRank(6,false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 숫자와 보너스 번호가 일치할 경우 2등이다.")
    @Test
    void secondRankTest() {
        Rank rank = Rank.findRank(5,true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 숫자가 일치하고 보너스가 일치하지 않는 경우 3등이다.")
    @Test
    void thirdRankTest() {
        Rank rank = Rank.findRank(5,false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 숫자가 일치할 경우 4등이다.")
    @Test
    void fourthRankTest() {
        Rank rank = Rank.findRank(4,true);
        assertThat(rank).isEqualTo(Rank.FOURTH);

        rank = Rank.findRank(4,false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 숫자가 일치할 경우 5등이다.")
    @Test
    void fifthRankTest() {
        Rank rank = Rank.findRank(3,true);
        assertThat(rank).isEqualTo(Rank.FIFTH);

        rank = Rank.findRank(3,false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개의 숫자가 일치할 경우 꽝이다.")
    @Test
    void twoCommonTest() {
        Rank rank = Rank.findRank(2,true);
        assertThat(rank).isEqualTo(Rank.EMPTY);

        rank = Rank.findRank(2,false);
        assertThat(rank).isEqualTo(Rank.EMPTY);
    }

    @DisplayName("1개의 숫자가 일치할 경우 꽝이다.")
    @Test
    void oneCommonTest() {
        Rank rank = Rank.findRank(1,true);
        assertThat(rank).isEqualTo(Rank.EMPTY);

        rank = Rank.findRank(1,false);
        assertThat(rank).isEqualTo(Rank.EMPTY);
    }

    @DisplayName("0개의 숫자가 일치할 경우 꽝이다.")
    @Test
    void zeroCommonTest() {
        Rank rank = Rank.findRank(0,true);
        assertThat(rank).isEqualTo(Rank.EMPTY);

        rank = Rank.findRank(0,false);
        assertThat(rank).isEqualTo(Rank.EMPTY);
    }
}
