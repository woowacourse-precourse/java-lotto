package lotto.exception;

import static lotto.exception.Validator.NEED_TO_INPUT_NUMBER;
import static lotto.exception.Validator.NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND;
import static lotto.exception.Validator.NEED_TO_INPUT_RIGHT_NUMBER_RANGE;
import static lotto.exception.Validator.NEED_TO_INPUT_SIX_NUMBER;
import static lotto.exception.Validator.NEED_TO_NOT_DUPLICATE;
import static lotto.exception.Validator.NEED_TO_USE_COMMA;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    public static final String VALUE_IS_NOT_NUMBER = "가나다";
    public static final String NUMBER_NOT_DIVISIBLE_BY_ONE_THOUSAND = "2500";

    public static final String VALUE_IS_NOT_USE_COMMA = "123";
    public static final String VALUE_IS_NOT_NUMBER_USE_COMMA = "가,나,다,1,4,5";
    public static final String VALUE_SIZE_IS_NOT_SIX = "1,2,3";
    public static final String VALUE_RANGE_IS_NOT_RIGHT_USE_COMMA = "1,2,3,4,5,46";

    public static final String VALUE_IS_DUPLICATE = "1";
    public static final String VALUE_RANGE_IS_NOT_RIGHT = "47";

    public static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    public static final String INPUT_MONEY_RIGHT_VALUE = "3000";
    public static final String INPUT_WINNING_NUMBERS_RIGHT_VALUE = "1,2,3,4,5,6";
    public static final String INPUT_BONUS_MONEY_RIGHT_VALUE = "7";


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

        @DisplayName("1000의 배수를 입력하면 정상통과한다.")
        @Test
        void test3() {
            assertThatNoException()
                    .isThrownBy(() -> validator.validateMoney(INPUT_MONEY_RIGHT_VALUE));
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

        @DisplayName("숫자가 6자리가 아니면 예외를 반환한다")
        @Test
        void test2() {
            assertThatThrownBy(() -> validator.validateWinningNumbers(VALUE_SIZE_IS_NOT_SIX))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_SIX_NUMBER);
        }


        @DisplayName("숫자가 아니면 예외를 반환한다")
        @Test
        void test3() {
            assertThatThrownBy(() -> validator.validateWinningNumbers(VALUE_IS_NOT_NUMBER_USE_COMMA))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_NUMBER);
        }

        @DisplayName("범위가 벗어나는 숫자가 있다면 예외를 반환한다.")
        @Test
        void test4() {
            assertThatThrownBy(() -> validator.validateWinningNumbers(VALUE_RANGE_IS_NOT_RIGHT_USE_COMMA))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_RIGHT_NUMBER_RANGE);
        }

        @DisplayName("정상로직")
        @Test
        void test5() {
            assertThatNoException()
                    .isThrownBy(() -> validator
                            .validateWinningNumbers(INPUT_WINNING_NUMBERS_RIGHT_VALUE));
        }
    }

    @Nested
    @DisplayName("validateBonusNumber method")
    class Class3 {


        @DisplayName("숫자가 아니면 예외를 반환한다")
        @Test
        void test1() {
            assertThatThrownBy(() ->
                    validator.validateBonusNumber(VALUE_IS_NOT_NUMBER, WINNING_NUMBERS))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_NUMBER);
        }

        @DisplayName("범위에 벗어나는 숫자가 있다면 예외를 반환한다.")
        @Test
        void test2() {
            assertThatThrownBy(() -> validator.validateBonusNumber(VALUE_RANGE_IS_NOT_RIGHT, WINNING_NUMBERS))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_INPUT_RIGHT_NUMBER_RANGE);
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외를 반환한다.")
        @Test
        void test3() {
            assertThatThrownBy(() -> validator.validateBonusNumber(VALUE_IS_DUPLICATE, WINNING_NUMBERS))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEED_TO_NOT_DUPLICATE);
        }

        @DisplayName("정상 로직")
        @Test
        void test4() {
            assertThatNoException()
                    .isThrownBy(() -> validator.validateBonusNumber(INPUT_BONUS_MONEY_RIGHT_VALUE, WINNING_NUMBERS));
        }
    }
}