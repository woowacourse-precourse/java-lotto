package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("6개 이상의 당첨번호를 넣으면 예외가 발생한다.")
    @Test
    void inputWinningNumbersCount() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7", "8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨번호에 범위를 벗어난 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberRange() {
        assertThatThrownBy(() -> new WinningNumber("1,2,46,35,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨번호에 중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumbersDuplicate() {
        assertThatThrownBy(() -> new WinningNumber("1,2,2,3,4,5", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨번호에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberContainsNotNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,a,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void inputBonusNumberContainsNotNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "4b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호에 범위를 벗어난 값을 입력하면 예외가 발생한다.")
    @Test
    void inputBonusNumberRange() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "47"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력값이 정상적으로 변경되는지 테스트.")
    @Test
    void convertWinningAndBonusNumbers() {
        String inputWinNum = "1,2,3,4,5,6";
        String inputBonusNum = "7";

        WinningNumber winningNumber = new WinningNumber(inputWinNum, inputBonusNum);
        assertThat(winningNumber.getWinningNumbers()).isEqualTo(List.of(1, 2 ,3 ,4 ,5, 6));
        assertThat(winningNumber.getBonusNumber()).isEqualTo(7);
    }
}