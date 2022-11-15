package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("보너스 번호가 로또번호 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverRange() {
        assertThatThrownBy(() -> new WinningLotto((List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또번호 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByUnderRange() {
        assertThatThrownBy(() -> new WinningLotto((List.of(1, 2, 3, 4, 5, 6)), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNUmber() {
        assertThatThrownBy(() -> new WinningLotto((List.of(1, 2, 3, 4, 5, 6)), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
