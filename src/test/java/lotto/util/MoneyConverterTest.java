package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyConverterTest {
    private static final String EXCEPTION_MESSAGE_NO_NUMBER = "[ERROR] 숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";
    private static final String START_ZERO_EXCEPTION_MESSAGE = "[ERROR] 0으로 시작하는 돈은 없습니다. ex)001000";

    @DisplayName("숫자가 아닌값이거나 자료형 초과시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"i", "erdsa", "감사", "#$%&", "\n", "", "12a", "a12", "1000원", "10000000000"})
    void createMoneyNotNumber(String input) {
        assertThatThrownBy(() -> MoneyConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_NO_NUMBER);
    }

    @DisplayName("구매금액이 0으로 시작하는 문자열일시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"01000", "01001000", "0001000"})
    void createMoneyStartZero(String input) {
        assertThatThrownBy(() -> MoneyConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(START_ZERO_EXCEPTION_MESSAGE);
    }
}
