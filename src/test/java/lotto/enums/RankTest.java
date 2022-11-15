package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RankTest {

    @DisplayName("맞은개수,보너스번호 일치 여부로부터 적절한 당첨순위 반환")
    @Test
    void getRankByCorrectCount() {
        assertThat(Rank.getRank(3,false)).isEqualTo(Rank.RANK_FIVE);
        assertThat(Rank.getRank(4,false)).isEqualTo(Rank.RANK_FOUR);
        assertThat(Rank.getRank(5,false)).isEqualTo(Rank.RANK_THREE);
        assertThat(Rank.getRank(5,true)).isEqualTo(Rank.RANK_TWO);
        assertThat(Rank.getRank(6,false)).isEqualTo(Rank.RANK_ONE);
    }
}