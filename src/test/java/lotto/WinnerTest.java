package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinnerTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("당첨 번호 입력 시 쉼표를 올바르게 사용하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1.2.3.4.5.6:45", "123456:45", "1&2&3&4&5&6:45", "1,2,3,,,4,5,6:45", "1,2,3,4,5and6:45"},
            delimiter = ':')
    void winningNumbersWithoutProperComma(String winningNumbers, String bonusNumber) {
        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호 입력 시 1에서 45 사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void bonusNumberOutOfRange() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "46";

        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호 입력 시 당첨 번호와 겹치면 예외가 발생한다.")
    @Test
    void bonusNumberIncludedInWinningNumbers() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "6";

        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}