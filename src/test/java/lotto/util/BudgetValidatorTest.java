package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.util.validator.BudgetValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BudgetValidatorTest {

    private BudgetValidator budgetValidator;

    @BeforeEach
    void setUp() {
        budgetValidator = new BudgetValidator();
    }

    @Nested
    class invalidInputTest {

        @DisplayName("자연수가 아닌 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"한글", "moonja", "   문자   wi t h 공    백   ", "-1000", "- 2 32 2190000"})
        void 자연수가_아닌_입력(String input) {
            assertThatThrownBy(() -> budgetValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }


        @DisplayName("int 범위를 초과한 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"2222222222222222222222222222000", "1294013905724312349120948120000"})
        void int_범위를_벗어난_입력(String input) {
            assertThatThrownBy(() -> budgetValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage());
        }


        @DisplayName("로또의 가격으로 나누어 떨어지지 않는 입력의 경우 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"123456", "123", "911", "10"})
        void 숫자가_아닌_입력(String input) {
            assertThatThrownBy(() -> budgetValidator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_UNIT_OF_BUDGET.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"222000", "22222000", " 1   0    0  0   "})
        void 정상_입력(String input) {
            assertThatCode(() -> budgetValidator.validate(input))
                    .doesNotThrowAnyException();
        }

    }
}