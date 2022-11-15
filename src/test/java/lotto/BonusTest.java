package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void duplicateBonusNumandWinningNum() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(
            () -> new Bonus(1, winningNum)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
