package lotto.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    @DisplayName("올바른 번호를 입력하면 당첨 번호가 정상적으로 생성된다.")
    void createWinningLotto() {
        // given
        String numbers = "1,2,3,4,5,6";
        String bonusNumber = "7";
        WinningLotto winningLotto = WinningLotto.of(numbers, bonusNumber);

        // expect
        assertThat(winningLotto.getNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getBonusNumber())
                .isEqualTo(7);
    }

    @Test
    @DisplayName("당첨 번호를 만들때 잘못된 숫자를 입력하면 예외가 발생한다.")
    void createWinningLottoByWrongNumber1() {
        // given
        String numbers = "1,2,3,4,5,46";
        String bonusNumber = "7";
        // expect
        assertThatThrownBy(() -> WinningLotto.of(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 로또 번호가 아닙니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 잘못된 숫자를 입력하면 예외가 발생한다.")
    void createWinningLottoByWrongNumber2() {
        // given
        String numbers = "0,1,2,3,4,5";
        String bonusNumber = "6";
        // expect
        assertThatThrownBy(() -> WinningLotto.of(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 로또 번호가 아닙니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 잘못된 숫자를 입력하면 예외가 발생한다.")
    void createWinningLottoByWrongNumber3() {
        // given
        String numbers = "0,1,2,3,4,5,";
        String bonusNumber = "6";
        // expect
        assertThatThrownBy(() -> WinningLotto.of(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 로또 번호가 아닙니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 중복된 숫자가 있으면 예외가 발생한다.")
    void createWinningLottoByDuplicate() {
        // given
        String input = "1,2,3,4,5,5";
        String bonusNumber = "6";
        // expect
        assertThatThrownBy(() -> WinningLotto.of(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("당첨 번호를 만들때 보너스 번호와 중복되면 예외가 발생한다.")
    void createWinningLottoByDuplicateBonusNumber() {
        // given
        String input = "1,2,3,4,5,6";
        String bonusNumber = "6";

        // expect
        assertThatThrownBy(() -> WinningLotto.of(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호와 중복이 있습니다.");
    }
}