package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}