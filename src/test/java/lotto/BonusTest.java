package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @DisplayName("보너스 번호가 1이상 45이하의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRange() {
        assertThatThrownBy(() -> new Bonus(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
