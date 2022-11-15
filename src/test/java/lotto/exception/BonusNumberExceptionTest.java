package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusNumberExceptionTest {

    @Test
    void 보너스번호_숫자인지_확인() {

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberDigit("test"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberDigit("12t"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberDigit("테스트"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_1과_45_사이인지_확인() {

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberRange(-1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberRange(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_올바른_입력() {
        BonusNumberException.checkBonusNumber("34");
        BonusNumberException.checkBonusNumber("45");
        BonusNumberException.checkBonusNumber("1");
        BonusNumberException.checkBonusNumber("10");
    }

    @Test
    void 보너스번호_잘못된_입력() {
        assertThatThrownBy(() -> BonusNumberException.checkBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumber(" "))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumber("테스트"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumberException.checkBonusNumber("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
