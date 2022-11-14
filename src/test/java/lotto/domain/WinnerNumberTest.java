package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerNumberTest {
    private final String OUT_OF_FORMAT = ExceptionMessage.ERROR + ExceptionMessage.WINNING_FORMAT_ERROR;
    private final String DUPLICATED_NUMBER = ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER;
    private final String OUT_OF_BOUNDS = ExceptionMessage.ERROR + ExceptionMessage.OUT_OF_BOUNDS;
    private final String NON_NUMERIC = ExceptionMessage.NON_NUMERIC_INPUT;

    @DisplayName("당첨 번호 입력시 발생할 수 있는 모든 예외 검증 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"1,2,3,4,5,6,7:" + OUT_OF_FORMAT,
                    "1,2,2,3,4,5:" + DUPLICATED_NUMBER,
                    "1,2,3,4,46,5:" + OUT_OF_BOUNDS},
            delimiter = ':'
    )
    void 잘못된_당첨번호_입력시_예외_발생(String inputLottoNumber, String exceptionMessage) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(List.of(inputLottoNumber, "45")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exceptionMessage);
    }

    @DisplayName("보너스 번호 입력시 발생할 수 있는 모든 예외 검증 테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"1,2,3,4,5,6:a:" + NON_NUMERIC,
                    "1,2,3,4,5,6:46:" + OUT_OF_BOUNDS,
                    "1,2,3,4,5,6:6:" + DUPLICATED_NUMBER},
            delimiter = ':'
    )
    void 잘못된_보너스번호_입력시_예외_발생(String inputLottoNumber, String inputBonusNumber, String exceptionMessage) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(List.of(inputLottoNumber, inputBonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exceptionMessage);
    }
}
