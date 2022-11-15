package lotto.enumeration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("6개 일치 시 1등 당첨이다.")
    @Test
    void caseFirst() {
        assertThat(Ranking.create(6,false)).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("5개 일치 + 보너스 번호 일치 시 2등 당첨이다.")
    @Test
    void caseSecond() {
        assertThat(Ranking.create(5,true)).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("5개 일치 시 3등 당첨이다.")
    @Test
    void caseThird() {
        assertThat(Ranking.create(5,false)).isEqualTo(Ranking.THIRD);
    }

    @DisplayName("4개 일치 시 4등 당첨이다.")
    @Test
    void caseForth() {
        assertThat(Ranking.create(4,false)).isEqualTo(Ranking.FORTH);
    }

    @DisplayName("3개 일치 시 5등 당첨이다.")
    @Test
    void caseFifth() {
        assertThat(Ranking.create(3,false)).isEqualTo(Ranking.FIFTH);
    }

    @DisplayName("2개 이하로 일치하면 당첨 실패이다.")
    @Test
    void case1() {
        assertThat(Ranking.create(2,false)).isEqualTo(Ranking.NON_WINNER);
        assertThat(Ranking.create(1,false)).isEqualTo(Ranking.NON_WINNER);
        assertThat(Ranking.create(0,false)).isEqualTo(Ranking.NON_WINNER);
    }
}