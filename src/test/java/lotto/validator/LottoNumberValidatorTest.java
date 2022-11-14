package lotto.validator;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberValidatorTest {
    @Test
    void 당첨_로또_입력시_제대로된_형식으로_입력하지_않은_경우_예외_발생_쉼표X() {
        assertThatThrownBy(() -> LottoNumberValidator.validate("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_제대로된_형식으로_입력하지_않은_경우_예외_발생_숫자6개_X() {
        assertThatThrownBy(() -> LottoNumberValidator.validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_1보다_작은_숫자를_포함하는_경우_예외_발생() {
        assertThatThrownBy(() -> LottoNumberValidator.validate("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_45보다_큰_숫자를_포함하는_경우_예외_발생() {
        assertThatThrownBy(() -> LottoNumberValidator.validate("1,2,3,48,49,50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void 로또_숫자_안에_중복된_숫자가_있는_경우_예외_발생() {
        assertThatThrownBy(() -> LottoNumberValidator.validate("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_DUPLICATE_EXCEPTION.getMessage());
    }
}
