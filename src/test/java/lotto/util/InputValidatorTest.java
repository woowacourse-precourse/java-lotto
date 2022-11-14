package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.errorenum.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("당첨 번호를 입력받을 때 지정된 구분자, 숫자 외의 입력이 들어올 경우 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 2,3,4,5,6", "1,2,ㄱ,3,4,5", "1/2/3/4/5/6", " 1 2 3 4 5 6"})
    void createInputWithWrongCharacter(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumberDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.WRONG_DELIMITER.printError());
    }

    @DisplayName("당첨 번호를 입력받을 때 숫자와 구분자로만 구성된 입력이 들어올 경우 정상 실행된다")
    @Test
    void createInputWithNoError() {
        String input = "1,2,3,4,5,6";

        InputValidator.validateWinningNumberDelimiter(input);

        //then : pass test
    }

    @DisplayName("구입금액, 보너스 번호 입력 시 숫자 외의 값이 들어오면 오류가 발생한다")
    @Test
    void createInputWithNonNumber() {
        String input = "5000a";

        assertThatThrownBy(() -> InputValidator.validateParsingInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.ACCEPT_ONLY_NUMBER.printError());
    }

}
