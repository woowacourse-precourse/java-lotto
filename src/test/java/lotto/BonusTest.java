package lotto;

import lotto.model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @DisplayName("보너스 번호에 1~45 이외의 숫자가 있거나, 숫자가 아닌 것이 있으면 예외가 발생한다.")
    @Test
    void createBonusByValidateBonus() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}