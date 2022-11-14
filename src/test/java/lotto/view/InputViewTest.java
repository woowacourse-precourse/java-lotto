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

}
