package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberValidatorTest {

    private WinningNumberValidator winningNumberValidator;

    @BeforeEach
    void setUp() {
        winningNumberValidator = new WinningNumberValidator();
    }

    @Nested
    class invalidInput {

        @DisplayName("자연수가 아닌 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"한글", "moonja", "   문자   wi t h 공    백   ", "-1000", "- 2 32 2190000"})
        void 자연수가_아닌_입력(String input) {
            assertThatThrownBy(() -> winningNumberValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}