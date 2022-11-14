package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoMachineTest {

    private final WinningLottoMachine winningLottoMachine = new WinningLottoMachine();

    @DisplayName("정답 로또 번호중 범위가 맞지 않는 수가 있으면 예외가 발생한다.")
    @Test
    void inputNumbersByOutOfRange() {
        String input = "2,56,22,1,144,2";

        assertThatThrownBy(() -> winningLottoMachine.giveWinningLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("정답 로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void inputNumbersByOverSizeOrUnderSize() {
        String input = "2,56,22,1";

        assertThatThrownBy(() -> winningLottoMachine.giveWinningLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6 개의 숫자가 아닙니다.");
    }

    @DisplayName("나누어진 정답 로또 번호의 입력중 숫자외의 문자가 있으면 예외가 발생한다.")
    @Test
    void inputNumbersByNonNumeric() {
        String input = "2,56,22,1,a";

        assertThatThrownBy(() -> winningLottoMachine.giveWinningLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수가 아닌 입력이 있습니다.");

    }

    @DisplayName("정답 로또 숫자의 입력이 , 로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void inputNumbersNotContainSplitCharacter() {
        String input = "144141.1515";

        assertThatThrownBy(() -> winningLottoMachine.giveWinningLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("분할될 수 없는 입력입니다.");
    }

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