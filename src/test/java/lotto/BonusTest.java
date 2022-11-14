package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @DisplayName("보너스 번호가 1~45까지의 수가 아니면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Bonus(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}