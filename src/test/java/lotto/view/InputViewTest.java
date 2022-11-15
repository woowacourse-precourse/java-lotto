package lotto.view;

import lotto.validation.InputValidation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {

    @DisplayName("예외 처리 : 입력값이 숫자인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"100h","hello",""," "})
    void isDigitInputValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidation.isValidInput(input));
    }

    @DisplayName("예외 처리 : 입력받은 당첨 번호가 ,로 구분되어있고 숫자값인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e,f", ",1,3,4,5,6", "1, 2, 3, 4, 5, 6", "1,2,3,4,5,6 ", " ", ""})
    void isValidWinningNumbersInput(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidation.isValidInput(input));
    }

}
