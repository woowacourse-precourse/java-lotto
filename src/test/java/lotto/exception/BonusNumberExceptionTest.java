package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusNumberExceptionTest {

    @Test
    void 보너스숫자_숫자인지_확인() {

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberDigit("test"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberDigit("12t"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberDigit("테스트"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스숫자_1과_45_사이인지_확인() {

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberRange(-1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberRange(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
