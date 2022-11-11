package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void 삼등찾기테스트() {
        Rank  rank = Rank.findByCorrectCountAndBonus(5,false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
    @Test
    void 이등찾기테스트() {
        Rank  rank = Rank.findByCorrectCountAndBonus(5,true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
    @Test
    void 일등찾기테스트() {
        Rank  rank = Rank.findByCorrectCountAndBonus(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
    @Test
    void 당첨실패테스트() {
        Rank  rank = Rank.findByCorrectCountAndBonus(2,false);
        assertThat(rank).isEqualTo(null);
    }
}