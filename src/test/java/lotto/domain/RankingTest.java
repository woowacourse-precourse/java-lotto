package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void 당첨개수와_보너스여부로_당첨순위찾기() {
        assertThat(Ranking.findByRightCountAndHasBonusNumber(3, false)).isEqualTo(Ranking.FIFTH);
        assertThat(Ranking.findByRightCountAndHasBonusNumber(3, true)).isEqualTo(Ranking.FIFTH);
        assertThat(Ranking.findByRightCountAndHasBonusNumber(4, false)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.findByRightCountAndHasBonusNumber(4, true)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.findByRightCountAndHasBonusNumber(5, false)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.findByRightCountAndHasBonusNumber(5, true)).isEqualTo(Ranking.SECOND);
        assertThat(Ranking.findByRightCountAndHasBonusNumber(6, false)).isEqualTo(Ranking.FIRST);
    }
}
