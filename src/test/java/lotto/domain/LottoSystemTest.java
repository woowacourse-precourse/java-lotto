package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSystemTest {
    LottoSystem system = new LottoSystem();

    @DisplayName("당첨 번호 임력 시 숫자 이외에 값이 있는지 확인한다.")
    @Test
    void InputInvalidType() {
        String[] invalidTypes = {
                "1, 2, 3, 4, 6, w",
                "1, e, r, @, 1, 2",
        };
        for (String invalidInput : invalidTypes) {
            assertThatThrownBy(() -> system.setWinningNumbers(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}