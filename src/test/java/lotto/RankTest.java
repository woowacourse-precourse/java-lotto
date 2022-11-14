package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("당첨 등수 찾기 테스트")
    @Test
    void findRank() {
        assertThat(Rank.findRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
    }
}
