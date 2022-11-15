package lotto.validator;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyValidatorTest {
    @Test
    void 구매금액이_숫자가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> MoneyValidator.validateType("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.MONEY_TYPE_EXCEPTION.getMessage());
    }

    @Test
    void 구매금액이_1000원_단위로_나누어떨어지지_않는_경우_예외_발생() {
        assertThatThrownBy(() -> MoneyValidator.validateValue(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.MONEY_VALUE_EXCEPTION.getMessage());
    }

    @Test
    void 구매금액이_정수고_1000원_단위로_나누어떨어지면_통과() {
        MoneyValidator.validate("1000");
        MoneyValidator.validate("2000");
        MoneyValidator.validate("3000");
    }

    @Test
    void 최소금액이_1000원_미만인_경우_예외_발생() {
        assertThatThrownBy(() -> MoneyValidator.validateMinimumValue(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.MONEY_MINIMUM_VALUE_EXCEPTION.getMessage());
    }
}
