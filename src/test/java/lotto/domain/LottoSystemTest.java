package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSystemTest {
    LottoSystem system = new LottoSystem();

    @DisplayName("당첨 번호 입력 시 숫자 이외에 값이 있는지 확인한다.")
    @Test
    void InputInvalidType() {
        String[] invalidInput = {
                "1, 2, 3, 4, 6, w",
                "1, e, r, @, 1, 2",
                "wofjweoifjweio124"
        };
        for (String input : invalidInput) {
            assertThatThrownBy(() -> system.setWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨 번호 입력 시 숫자가 6개 입력되었는지 확인한다")
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

    @DisplayName("당첨 번호 입력 시 1부터 45 사이의 숫자인지 확인한다")
    @Test
    void InputInvalidRange() {
        String[] invalidInput = {
                "1, 46, 2, 3, 4, 5",
                "-1, 45, 4, 24, 14, 5",
        };
        for (String input : invalidInput) {
            assertThatThrownBy(() -> system.setWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨 번호 입력 시 모두 다른 숫자인지 확인한다")
    @Test
    void InputDuplicateNumbers() {
        String[] invalidInput = {
                "1, 2, 3, 5, 5, 6",
                "7, 8, 11, 10, 11, 12",
        };
        for (String input : invalidInput) {
            assertThatThrownBy(() -> system.setWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}