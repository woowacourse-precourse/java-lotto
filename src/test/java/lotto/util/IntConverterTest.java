package lotto.util;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntConverterTest {
    private static final String EXCEPTION_MESSAGE_NO_NUMBER = "[ERROR] 숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";

    @DisplayName("숫자가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "$%", "\n"})
    void InputIsNotNumber(String input) {
        assertThatThrownBy(() -> IntConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_NO_NUMBER);
    }
}
