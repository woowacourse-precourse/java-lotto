package lotto.validator;


import static org.assertj.core.api.Assertions.*;

import lotto.constants.messages.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private static final String ONLY_NUMBER = "-123," + ExceptionMessage.ERROR + ExceptionMessage.NON_NUMERIC_INPUT;
    private static final String START_WITH_ZERO = "012," + ExceptionMessage.ERROR + ExceptionMessage.START_WItH_ZERO;
    private static final String NO_ZERO = "0," + ExceptionMessage.ERROR + ExceptionMessage.ZERO_INPUT;

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("구매 금액 입력시 발생하는 모든 예외 검증 테스트")
    @ParameterizedTest
    @CsvSource({ONLY_NUMBER, START_WITH_ZERO, NO_ZERO})
    void 잘못된_구매금액_입력시_모든_예외_발생(String inputPrice, String exceptionMessage) {
        // given
        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateInputPrice(inputPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exceptionMessage);
    }
}