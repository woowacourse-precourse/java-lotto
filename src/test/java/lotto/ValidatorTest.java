package lotto;

import lotto.exception.ExceptionType;
import lotto.exception.Validator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Validator.validateMoneyString("1000");
        Validator.validateMoneyString("2000");
        Validator.validateMoneyString("3000");
    }

    @Test
    void 당첨_로또_입력시_제대로된_형식으로_입력하지_않은_경우_예외_발생_쉼표X() {
        assertThatThrownBy(() -> Validator.validateLottoString("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_제대로된_형식으로_입력하지_않은_경우_예외_발생_숫자6개_X() {
        assertThatThrownBy(() -> Validator.validateLottoString("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_INPUT_FORMAT_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_1보다_작은_숫자를_포함하는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLottoString("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void 당첨_로또_입력시_45보다_큰_숫자를_포함하는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLottoString("1,2,3,48,49,50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_RANGE_EXCEPTION.getMessage());
    }

    @Test
    void 로또_숫자_안에_중복된_숫자가_있는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateLottoString("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOTTO_DUPLICATE_EXCEPTION.getMessage());
    }

    @Test
    void 보너스_숫자_입력시_숫자가_아닌_문자를_입력하는_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.BONUS_INPUT_TYPE_EXCEPTION.getMessage());
    }
    @Test
    void 보너스_숫자가_로또번호에_포함된_수인_경우_예외_발생() {
        assertThatThrownBy(() -> Validator.validateBonusNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.BONUS_DUPLICATE_EXCEPTION.getMessage());
    }
}