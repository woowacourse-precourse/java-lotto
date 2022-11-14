package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoMachineTest {

    private final WinningLottoMachine winningLottoMachine = new WinningLottoMachine();

    @DisplayName("보너스 넘버의 입력이 0이면 예외가 발생힌다.")
    @Test
    void inputBonusNumberByBlank() {
        String input = "";

        assertThatThrownBy(() -> winningLottoMachine.giveWinningLottoBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열이 입력되었습니다.");
    }

    @DisplayName("보너스 넘버의 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputBonusNumberByNonNumeric() {
        String input = "aa";

        assertThatThrownBy(() -> winningLottoMachine.giveWinningLottoBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수가 아닌 입력이 있습니다.");
    }
}