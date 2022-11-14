package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusTest {
    private final String notOneMessage = "[ERROR] 보너스번호는 숫자 1개여야 합니다.";

    @Test
    @DisplayName("두 개 이상의 값은 에러가 발생한다.")
    void checkNumberCount() {
        // given
        String bonus = "1,9";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> Bonus.checkException(bonus));
    }

    @Test
    @DisplayName("두 개 이상의 값을 받아 에러가 발생하면 [ERROR]로 시작하는 메세지를 반환한다.")
    void errorMessageTest() {
        // given
        String bonus = "3 6";

        try {
            // when
            Bonus.checkException(bonus);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo(notOneMessage);
        }
    }

    @Test
    @DisplayName("1 ~ 45 범위를 벗어나는 값은 에러가 발생한다.")
    void checkNumberRange() {
        // given
        String bonus = "123";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> Bonus.checkException(bonus));
    }
}
