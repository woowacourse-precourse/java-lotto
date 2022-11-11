package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해 주세요.";
    private static final String SEPARATOR_ERROR = "[ERROR] 구분자 ',' 를 입력해 주세요.";
    private static final String AMOUNT_UNIT_ERROR = "[ERROR] 1000원 단위로 입력하세요.";

    @ParameterizedTest
    @DisplayName("1000원으로 나누어 떨어지지 않을 때 예외")
    @ValueSource(strings = {
            "999",
            "1001"
    })
    void validateAmount(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThatThrownBy(Input::purchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_UNIT_ERROR);
    }

    @ParameterizedTest
    @DisplayName("구매 금액 문자 입력했을 때 예외")
    @ValueSource(strings = {
            "1000j",
            "abcde"
    })
    void validateNumber(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThatThrownBy(Input::purchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_ERROR);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 문자 입력했을 때 예외")
    @ValueSource(strings = {
            "1,2,a,3,4,5",
            "a,b,c,d,e,f",
            "1,2.3,4,5,6"
    })
    void validateNumberOfWinningNumber(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThatThrownBy(Input::winningNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_ERROR);
    }

    @Test
    @DisplayName("당첨 번호 문자 입력값에 구분자 ',' 가 없을 때 예외")
    void validateSeparatorOfWinningNumber() {
        InputStream in = generateInput("1.2.3.4.5.6");
        System.setIn(in);

        assertThatThrownBy(Input::winningNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SEPARATOR_ERROR);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 문자 입력했을 때 예외")
    @ValueSource(strings = {
            "a",
            " "
    })
    void validateBonusNumber(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThatThrownBy(Input::bonus)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_ERROR);
    }

    private InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
