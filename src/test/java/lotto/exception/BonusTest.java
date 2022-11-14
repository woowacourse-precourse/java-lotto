package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusTest {

    @Test
    @DisplayName("두 개 이상의 값은 에러가 발생한다.")
    void checkNumberCount() {
        // given
        String bonus = "1,9";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> Bonus.checkException(bonus));
    }
}
