package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("등수와 당첨 갯수를 잘 매치시키는지 확인한다")
    @Test
    void getRankMatchTest() {
        assertThat(Rank.FIRST.getMatch()).isEqualTo(6);
        assertThat(Rank.SECOND.getMatch()).isEqualTo(5);
        assertThat(Rank.NOTHING.getMatch()).isEqualTo(0);
    }


}