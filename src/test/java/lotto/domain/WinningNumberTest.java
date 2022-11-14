package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void createDuplicateBonusNumberWithWinning() {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when, then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void createWrongRangeBonusNumber() {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 49;

        // when, then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
    }
}