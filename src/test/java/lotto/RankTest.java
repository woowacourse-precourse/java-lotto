package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {
    @DisplayName("매치 개수가 6초과이면 예외가 발생한다.")
    @Test
    void findRankOverMaxCount() {
        assertThatThrownBy(() -> Rank.of(7, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("매치 개수가 0미만이면 예외가 발생한다.")
    @Test
    void findRankUnderMinCount() {
        assertThatThrownBy(() -> Rank.of(-1, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("매치 개수가 0이상 2이하의 수라면 Rank NOTHING이 반환된다.")
    @Test
    void findNotingRank() {
        assertThat(Rank.of(1, false)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.of(2, true)).isEqualTo(Rank.NOTHING);
    }

}
