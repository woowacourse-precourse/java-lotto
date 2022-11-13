package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createOverlapWinningNumber() {
        assertThatThrownBy(() -> lottoMachine.checkThatWinningNumberIsRightInput("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void createNotSixSizeWinningNumber() {
        assertThatThrownBy(() -> lottoMachine.checkThatWinningNumberIsRightInput("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어난 숫자라면 예외가 발생한다.")
    @Test
    void createNotInRangeWinningNumber() {
        assertThatThrownBy(() -> lottoMachine.checkThatWinningNumberIsRightInput("1,2,3,4,5,50"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}