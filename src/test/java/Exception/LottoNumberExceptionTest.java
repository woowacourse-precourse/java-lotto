package Exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoNumberExceptionTest {
    @DisplayName("당첨 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputWinningNumberByContainCharacter() {
        Assertions.assertThatThrownBy(() -> LottoNumberException.checkWinningNumberException("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1에서 45사이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputWinningNumberByOutOfRange() {
        Assertions.assertThatThrownBy(() -> LottoNumberException.checkWinningNumberException("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputBonusNumberByContainCharacter() {
        Assertions.assertThatThrownBy(() -> LottoNumberException.checkBonusNumberException("a", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1에서 45사이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputBonusNumberByOutOfRange() {
        Assertions.assertThatThrownBy(() -> LottoNumberException.checkBonusNumberException("0", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 번호가 포함되어 있으면 예외가 발생한다.")
    @Test
    void winningNumberContainBonusNumber() {
        Assertions.assertThatThrownBy(() -> LottoNumberException.checkBonusNumberException("1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}