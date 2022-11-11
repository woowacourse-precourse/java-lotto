package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("당첨 번호에 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복 번호가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 5)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 추첨 번호를 비교하여 당첨 개수를 반환한다.")
    @Test
    void countMatchingWinningAndDrawingNumbers() {
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto userNumber = new Lotto(Arrays.asList(1, 3, 5, 10, 15, 16));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        Assertions.assertThat(winningLotto.countWinningNumber(userNumber)).isEqualTo(3);
    }
}