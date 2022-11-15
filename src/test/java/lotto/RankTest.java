package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Rank;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("맞춘 당첨 번호 개수와 보너스 당첨 여부에 따라 해당하는 상수 반환")
    @Test
    void createMoneyByLessSize() {
        assertSimpleTest(() -> {
            assertThat(Rank.of(3, true)).isEqualTo(Rank.NOTHING);
            assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
            assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
            assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
            assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
            assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        });
    }
}
