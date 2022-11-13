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

    @Test
    void 당첨_로또_입력시_제대로된_형식으로_입력하지_않은_경우_예외_발생_쉼표X() {
        assertThatThrownBy(() -> Validator.validateLotto("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_제대로된_형식으로_입력하지_않은_경우_예외_발생_숫자6개_X() {
        assertThatThrownBy(() -> Validator.validateLotto("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_1보다_작은_숫자를_포함하는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLotto("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_45보다_큰_숫자를_포함하는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLotto("1,2,3,48,49,50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void 로또_숫자_안에_중복된_숫자가_있는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_DUPLICATE_EXCEPTION.getMessage());
    }
}