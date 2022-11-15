package lotto.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("보너스 번호가 45를 초과하면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverRange() {
        assertThatThrownBy(() -> new BonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumberByUnderRange() {
        assertThatThrownBy(() -> new BonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getBonusNumber() {
    }
}