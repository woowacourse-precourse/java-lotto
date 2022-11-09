package lotto;

import static lotto.Validator.NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND;
import static lotto.Validator.NEED_TO_INPUT_NUMBER;
import static lotto.Validator.NEED_TO_INPUT_RIGHT_NUMBER_RANGE;
import static lotto.Validator.NEED_TO_INPUT_SIX_NUMBER;
import static lotto.Validator.NEED_TO_USE_COMMA;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    static final String VALUE_IS_NOT_NUMBER = "가나다";
    static final String NUMBER_NOT_DIVISIBLE_BY_ONE_THOUSAND = "2500";

    static final String VALUE_IS_NOT_USE_COMMA = "1 2 3";
    static final String VALUE_IS_NOT_NUMBER_USE_COMMA = "가,나,다";
    static final String VALUE_SIZE_IS_NOT_SIX = "1,2,3";
    static final String VALUE_RANGE_IS_NOT_RIGHT = "1,2,3,4,5,46";

    private Validator validator = new Validator();


    @Nested
    @DisplayName("validateMoney method")
    class Class1 {
        @DisplayName("숫자가 아니면 예외를 반환한다")
        @Test
        void test1() {
            assertThatThrownBy(() -> validator.validateMoney(VALUE_IS_NOT_NUMBER))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_NUMBER);
        }

        @DisplayName("1000으로 나누어 떨어지지 않으면 예외를 반환한다.")
        @Test
        void test2() {
            assertThatThrownBy(() -> validator.validateMoney(NUMBER_NOT_DIVISIBLE_BY_ONE_THOUSAND))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND);
        }
    }
    
    @Nested
    @DisplayName("validateWinningNumbers method")
    class Class2 {

        @DisplayName("콤마가 없으면 예외를 반환한다")
        @Test
        void test1() {
            assertThatThrownBy(() -> validator.validateWinningNumbers(VALUE_IS_NOT_USE_COMMA))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_USE_COMMA);
        }

        @DisplayName("숫자가 아니면 예외를 반환한다")
        @Test
        void test2() {
            assertThatThrownBy(() -> validator.validateWinningNumbers(VALUE_IS_NOT_NUMBER_USE_COMMA))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_NUMBER);
        }

        @DisplayName("숫자가 6자리가 아니면 예외를 반환한다")
        @Test
        void test3() {
            assertThatThrownBy(() -> validator.validateWinningNumbers(VALUE_SIZE_IS_NOT_SIX))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_SIX_NUMBER);
        }
        @DisplayName("범위가 벗어나는 숫자가 있다면 예외를 반환한다.")
        @Test
        void test4() {
            assertThatThrownBy(() -> validator.validateWinningNumbers(VALUE_RANGE_IS_NOT_RIGHT))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_RIGHT_NUMBER_RANGE);
        }
    }
}