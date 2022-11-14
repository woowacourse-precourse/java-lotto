package lotto.validator;


import static org.assertj.core.api.Assertions.*;

import lotto.constants.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();
    private final String ONLY_NUMBER = "-123," + ExceptionMessage.ERROR + ExceptionMessage.NON_NUMERIC_INPUT;
    private final String START_WITH_ZERO = "012," + ExceptionMessage.ERROR + ExceptionMessage.START_WItH_ZERO;
    private final String NO_ZERO = "0," + ExceptionMessage.ERROR + ExceptionMessage.ZERO_INPUT;

    private final String OUT_OF_FORMAT =
            "1,2,3,4,5,6,7," + ExceptionMessage.ERROR + ExceptionMessage.WINNING_FORMAT_ERROR;
    private final String DUPLICATED_NUMBER =
            "1,2,2,3,4,5," + ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER;
    private final String OUT_OF_BOUNDS = "1,2,3,4,46,5," + ExceptionMessage.ERROR + ExceptionMessage.OUT_OF_BOUNDS;

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

    @DisplayName("당첨 번호 입력시 발생할 수 있는 모든 예외 검증 테스트")
    @ParameterizedTest
    @CsvSource({OUT_OF_FORMAT, DUPLICATED_NUMBER, OUT_OF_BOUNDS})
    void 잘못된_당첨번호_입력시_모든_예외_발생(String inputWinningNumber, String exceptionMessage) {
        // given
        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateInputWinningNumber(inputWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exceptionMessage);
    }
}