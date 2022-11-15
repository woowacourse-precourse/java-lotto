package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BonusNumberTest {
    @Test
    void 보너스_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1~45 범위여야 합니다.");
    }

    @Test
    void 보너스_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1~45 범위여야 합니다.");
    }

    @Test
    void 보너스_번호가_정상_범위면_예외가_발생하지_않는다() {
        assertAll(
                () -> assertThatCode(() -> {
                    new BonusNumber(1);
                }).doesNotThrowAnyException(),

                () -> assertThatCode(() -> {
                    new BonusNumber(45);
                }).doesNotThrowAnyException()
        );
    }
}