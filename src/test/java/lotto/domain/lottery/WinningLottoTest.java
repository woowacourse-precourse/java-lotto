package lotto.domain.lottery;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨 번호가 1,2,3,4,5,6 형식이 아니라면 예외가 발생합니다. - 공백 포함")
    @Test
    void createWinningLottoInvalidFormat_with_space() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1,2,3,4,5,6 형식이 아니라면 예외가 발생합니다. - 연속적인 콤마")
    @Test
    void createWinningLottoInvalidFormat_with_comma() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6자리가 아니라면 예외가 발생합니다.")
    @Test
    void createWinningLottoOverSize() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생합니다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1부터 45까지가 아닌 수가 포함되면 예외가 발생합니다.")
    @Test
    void createWinningLottoOverRange() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,50"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}