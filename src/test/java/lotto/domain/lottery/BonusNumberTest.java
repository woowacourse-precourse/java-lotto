package lotto.domain.lottery;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호에 문자가 포함되면 예외가 발생합니다.")
    @Test
    void createBonusNumberWithCharacters() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("7$", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 당첨 번호와 중복이 포함되면 예외가 발생합니다.")
    @Test
    void createBonusNumberWithConflict() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("3", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1부터 45까지가 아닌 수가 포함되면 예외가 발생합니다.")
    @Test
    void createBonusNumberOverRange() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber("50", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}