package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호가 1~45 범위에 없으면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotValidNumber() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
