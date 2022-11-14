package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerNumberTest {
    private final String OUT_OF_FORMAT =
            "1,2,3,4,5,6,7," + ExceptionMessage.ERROR + ExceptionMessage.WINNING_FORMAT_ERROR;
    private final String DUPLICATED_NUMBER =
            "1,2,2,3,4,5," + ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER;
    private final String OUT_OF_BOUNDS = "1,2,3,4,46,5," + ExceptionMessage.ERROR + ExceptionMessage.OUT_OF_BOUNDS;

    @DisplayName("당첨 번호 입력시 발생할 수 있는 모든 예외 검증 테스트")
    @ParameterizedTest
    @CsvSource({OUT_OF_FORMAT, DUPLICATED_NUMBER, OUT_OF_BOUNDS})
    void 잘못된_당첨번호_입력시_모든_예외_발생(String inputLottoNumber, String exceptionMessage) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new WinnerNumber(List.of(inputLottoNumber, "45")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exceptionMessage);
    }
}
