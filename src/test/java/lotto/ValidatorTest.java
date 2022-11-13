package lotto;

import lotto.Exception.ExceptionType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @Test
    void 구매금액이_숫자가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateMoneyType("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.MONEY_TYPE_EXCEPTION.getMessage());
    }

    @Test
    void 구매금액이_1000원_단위로_나누어떨어지지_않는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateMoneyValue(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.MONEY_VALUE_EXCEPTION.getMessage());
    }

    @Test
    void 구매금액이_정수고_1000원_단위로_나누어떨어지면_통과() {
        Validator.validateMoney("1000");
        Validator.validateMoney("2000");
        Validator.validateMoney("3000");
    }
}