package lotto.validator;

import lotto.model.Lotto;
import lotto.exception.ExceptionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {
    @Test
    void 보너스_숫자_입력시_숫자가_아닌_문자를_입력하는_경우_예외_발생() {
        assertThatThrownBy(() -> BonusNumberValidator.validate(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.BONUS_INPUT_TYPE_EXCEPTION.getMessage());
    }
    @Test
    void 보너스_숫자가_로또번호에_포함된_수인_경우_예외_발생() {
        assertThatThrownBy(() -> BonusNumberValidator.validate(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.BONUS_DUPLICATE_EXCEPTION.getMessage());
    }
}
