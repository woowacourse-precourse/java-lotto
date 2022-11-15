package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {

    @DisplayName("보너스 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void bonusNumberNotInRange() {
        assertThatThrownBy(() -> Bonus.checkBonusInRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberInWinningNumber() {
        assertThatThrownBy(() -> new Bonus(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
