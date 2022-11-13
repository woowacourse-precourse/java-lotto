package lotto;

import static lotto.domain.ErrorMessage.INPUT_EMPTY_ERROR;
import static lotto.domain.ErrorMessage.SEPARATOR_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입금액 입력이 없으면 예외가 발생한다")
    @ParameterizedTest
    @EmptySource
    void emptyToMoney(String input) {
        assertThatThrownBy(() -> Converter.changeToMoney(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(INPUT_EMPTY_ERROR));
    }

    @DisplayName("구입금액 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test", "\b", "100000000000"})
    void moneyConstructorTest(String input) {
        assertThatThrownBy(() -> Converter.changeToMoney(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨번호 입력이 없으면 예외가 발생한다")
    @ParameterizedTest
    @EmptySource
    void emptyToWinningNumber(String input) {
        assertThatThrownBy(() -> Converter.changeToWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(INPUT_EMPTY_ERROR));
    }

    @DisplayName("당첨번호 구분자 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,,,,", "1,,2,3,,4,", ",1,2,3,4,5,6"})
    void invalidSeparator(String input) {
        assertThatThrownBy(() -> Converter.changeToWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(SEPARATOR_ERROR));
    }
}