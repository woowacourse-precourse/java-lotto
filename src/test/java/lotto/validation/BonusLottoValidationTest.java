package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusLottoValidationTest {

    @DisplayName("겹치는 숫자가 있으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void overlappingWinningLottoWithBonusLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(winningLotto), 1));
    }

    @DisplayName("숫자가 46이상이면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void overLottoWithBonusLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(winningLotto), 46));
    }

    @DisplayName("숫자가 -1 이하면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void downLottoWithBonusLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(winningLotto), -1));
    }

    @DisplayName("겹치는 숫자가 없으면 통과해도 된다.")
    @Test
    void success() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new WinningLotto(new Lotto(winningLotto), 7));
    }
}