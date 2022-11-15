package lotto;

import static lotto.utils.ErrorMessage.BONUS_NOT_NUMBER_ERROR;
import static lotto.utils.ErrorMessage.INPUT_EMPTY_ERROR;
import static lotto.utils.ErrorMessage.SEPARATOR_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입금액 입력이 없으면 예외가 발생한다.")
    @ParameterizedTest
    @EmptySource
    void emptyMoney(String input) {
        assertThatThrownBy(() -> Converter.changeToMoney(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(INPUT_EMPTY_ERROR));
    }

    @DisplayName("구입금액은 자연수가 아니고, 2,147,483,000가 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"test", "\b", "1000.10", "-1000", "100000000000"})
    void moneyNumberTest(String input) {
        assertThatThrownBy(() -> Converter.changeToMoney(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨번호 입력이 없으면 예외가 발생한다.")
    @ParameterizedTest
    @EmptySource
    void emptyWinningNumber(String input) {
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

    @DisplayName("보너스 번호 입력이 없으면 예외가 발생한다.")
    @ParameterizedTest
    @EmptySource
    void emptyBonusNumber(String input) {
        assertThatThrownBy(() -> Converter.changeToWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(INPUT_EMPTY_ERROR));
    }

    @DisplayName("보너스 번호는 양의 정수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12.3", "4 ", "-10"})
    void bonusNotNumber(String input) {
        assertThatThrownBy(() -> Converter.changeToBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(BONUS_NOT_NUMBER_ERROR));
    }
}