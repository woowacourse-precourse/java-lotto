package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class RankTest {

    @DisplayName("번호가 6개 일치하면 Rank.FIRST가 반횐된다.")
    @Test
    void checkRANK_FIRST() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("번호5개와 보너스번호가 일치하면 Rank.SECOND가 반횐된다.")
    @Test
    void checkRANK_SECOND() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("번호가 5개 일치하면 Rank.THIRD가 반횐된다.")
    @Test
    void checkRANK_THIRD() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("번호가 4개 일치하면 Rank.FOURTH가 반횐된다.")
    @Test
    void checkRANK_FOURTH() {
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("번호가 3개 일치하면 Rank.FIFTH가 반횐된다.")
    @Test
    void checkRANK_FIFTH() {
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("번호가 2개 이하로 일치하면 Rank.MISS가 반횐된다.")
    @Test
    void checkRANK_MISS() {
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }
}
