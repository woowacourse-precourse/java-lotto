package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningNumbersExceptionTest {

    @Test
    void 당첨번호_1과_45_사이인지_확인() {

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(-1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
