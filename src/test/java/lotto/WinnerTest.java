package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerTest {
    private static final String ERROR_OF_INVALID_FORMAT = "[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분되어야 합니다.";
    private static final String ERROR_OF_INVALID_INPUT = "[ERROR] 숫자가 아닌 값이 포함되어 있습니다. 공백이나 문자가 들어갔는지 확인해주세요.";
    private static final String ERROR_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_OF_DUPLICATE = "[ERROR] 겹치는 번호가 존재합니다.";

    @DisplayName("당첨 번호 입력 시 쉼표를 사용하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1.2.3.4.5.6:45", "123456:45", "1&2&3&4&5&6:45", "1+2+3+4+5+6:45", "12345and6:45"},
            delimiter = ':')
    void winningNumbersWithoutComma(String winningNumbers, String bonusNumber) {
        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OF_INVALID_FORMAT);
    }

    @DisplayName("당첨 번호 입력 시 숫자를 올바르게 쓰지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5, 6:45", "1,!!,3,4,5,6:45", "하나,2,3,4,5,6:45", "one,2,3,4,5,6:45"},
            delimiter = ':')
    void winningNumbersWithoutPropervalue(String winningNumbers, String bonusNumber) {
        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OF_INVALID_INPUT);
    }

    @DisplayName("당첨 번호 입력 시 1에서 45 사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void winningNumbersOutOfRange() {
        String winningNumbers = "1,2,3,4,5,46";
        String bonusNumber = "45";

        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OF_RANGE);
    }

    @DisplayName("당첨 번호 입력 시 겹치는 숫자가 있으면 예외가 발생한다.")
    @Test
    void winningNumbersWithDuplicates() {
        String winningNumbers = "1,2,3,4,5,5";
        String bonusNumber = "45";

        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OF_DUPLICATE);
    }

    @DisplayName("보너스 번호 입력 시 숫자를 올바르게 쓰지 않으면 예외가 발생한다.")
    @Test
    void inValidBonusNumber() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "seven";

        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OF_INVALID_INPUT);
    }

    @DisplayName("보너스 번호 입력 시 1에서 45 사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void bonusNumberOutOfRange() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "46";

        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OF_RANGE);
    }

    @DisplayName("보너스 번호 입력 시 당첨 번호와 겹치면 예외가 발생한다.")
    @Test
    void bonusNumberIncludedInWinningNumbers() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "6";

        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OF_DUPLICATE);
    }
}