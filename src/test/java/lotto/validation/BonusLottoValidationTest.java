package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusLottoValidationTest {

    @DisplayName("겹치는 숫자가 있으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void overlappingWinningLottoWithBonusLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Validation bonusLottoValidation = new BonusLottoValidation();
        assertThrows(IllegalArgumentException.class, () -> bonusLottoValidation.isValidate("1", winningLotto));
    }

    @DisplayName("겹치는 숫자가 없으면 통과해도 된다.")
    @Test
    void success() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Validation bonusLottoValidation = new BonusLottoValidation();
        assertDoesNotThrow(() -> bonusLottoValidation.isValidate("7", winningLotto));
    }
}