package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    void 보너스_번호가_1자리_혹은_2자리가_아닐경우_예외_발생() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new BonusNumber(""))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new BonusNumber("123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 보너스_번호가_1부터_45_사이가_아니라면_에외_발생() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new BonusNumber("0"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new BonusNumber("46"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
