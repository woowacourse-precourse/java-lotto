package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("잘못된 당첨 번호를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6s", "1 2 3 4 5 6", "1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4, 5,, 6, 7"})
    void givenUserInput_whenIllegalWinningNumbers_thenThrowException(String input) {
        assertThatThrownBy(() -> {
            new WinningNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 보너스 번호를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1s", "13q", "", "52"})
    void givenBonusNumber_whenIllegalInput_thenThrowException(String input) {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");
        assertThatThrownBy(() -> {
            winningNumber.setBonusNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}