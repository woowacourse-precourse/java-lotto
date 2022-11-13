package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Utils.Validator.BonusValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningRankTest {

    @DisplayName("로또 등수를 계산한다.")
    @Test
    void getRankbyEnum() {
        assertThat(WinningRank.SECOND)
                .isEqualTo(WinningRank.valueOf(5, true));
        assertThat(WinningRank.THIRD)
                .isEqualTo(WinningRank.valueOf(5, false));
        assertThatThrownBy(() -> WinningRank.valueOf(10, true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
