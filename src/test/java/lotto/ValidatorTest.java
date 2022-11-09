package lotto;

import static lotto.Validator.NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND;
import static lotto.Validator.NEED_TO_INPUT_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    static final String NUMBER_NOT_DIVISIBLE_BY_ONE_THOUSAND = "2500";
    static final String VALUE_IS_NOT_NUMBER = "가나다";

    private Validator validator = new Validator();

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