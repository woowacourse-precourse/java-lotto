package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSystemTest {
    LottoSystem system = new LottoSystem();

    @DisplayName("당첨 번호 임력 시 숫자 이외에 값이 있는지 확인한다.")
    @Test
    void InputInvalidType() {
        String[] invalidInput = {
                "1, 2, 3, 4, 6, w",
                "1, e, r, @, 1, 2",
        };
        for (String input : invalidInput) {
            assertThatThrownBy(() -> system.setWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨 번호 임력 시 숫자가 6개 입력되었는지 확인한다")
    @Test
    void InputInvalidCount() {
        String[] invalidInput = {
                "1, 2, 3, 4",
                "1, 2, 3, 4, 5, 6, 7",
        };
        for (String input : invalidInput) {
            assertThatThrownBy(() -> system.setWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}