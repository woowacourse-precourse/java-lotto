package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest(name = "입력값 숫자 테스트 {index} : {0}")
    @CsvSource(value = {"abcde", "1e345"})
    void String_숫자_테스트(String input) {
        assertThatThrownBy(() -> InputValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 구매금액_1000원_미만_테스트() {
        assertThatThrownBy(() -> InputValidator.validateLottoPurchaseNumber(960))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NOT_ENOUGH_MONEY_ERROR_MESSAGE);
    }

    @Test
    void 구매금액_1000원_나누기_테스트() {
        assertThatThrownBy(() -> InputValidator.validateLottoPurchaseNumber(14030))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NOT_DIVIDED_WITH_LOTTO_PRICE_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "당첨번호 입력 형식 예외 테스트 {index} : {0}")
    @ValueSource(strings = {"1,e,3,4,5,6", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void winningNumberInputValidationTest(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NUMBERS_INPUT_FORMAT_ERROR_MESSAGE);
    }
}