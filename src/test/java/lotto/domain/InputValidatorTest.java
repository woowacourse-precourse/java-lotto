package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest(name = "숫자가 아닌 입력에 대해 예외 발생 테스트 [{index}] : 입력값 - {0}")
    @CsvSource(value = {"abcde", "1e345"})
    void validateIsNumberTest(String input) {
        assertThatThrownBy(() -> InputValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NOT_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("로또 구매 금액 1000원 미만 입력시 예외 발생 테스트")
    @Test
    void validateMinimumPurchaseAmountTest() {
        assertThatThrownBy(() -> InputValidator.validateLottoPurchaseNumber(960))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NOT_ENOUGH_MONEY_ERROR_MESSAGE);
    }

    @DisplayName("로또 구매금액 1000원단위 나머지 발생시 예외 발생 테스트")
    @Test
    void validatePurchaseAmountUnitTest() {
        assertThatThrownBy(() -> InputValidator.validateLottoPurchaseNumber(14030))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NOT_DIVIDED_WITH_LOTTO_PRICE_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "당첨번호 입력 형식 예외 테스트 [{index}] : 입력값 - {0}")
    @ValueSource(strings = {"1,e,3,4,5,6", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void winningNumberInputValidationTest(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbersInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputValidator.NUMBERS_INPUT_FORMAT_ERROR_MESSAGE);
    }
}