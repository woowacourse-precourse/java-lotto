package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankEnumTest {

    @DisplayName("로또 당첨 금액을 확인한다.")
    @Test
    void createMyLotto() {
        assertThat(Rank.findRank(6, false).getPrize()).isEqualTo(2000000000);
        assertThat(Rank.findRank(6, true).getPrize()).isEqualTo(0);
    }
}
