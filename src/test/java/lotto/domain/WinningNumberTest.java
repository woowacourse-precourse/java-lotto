package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @DisplayName("보너스 번호 입력 시 1부터 45까지의 숫자인지 확인한다.")
    @Test
    void InputInvalidBonusNumber() {
        int[] invalidInput = {46, -1};
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6));
        for (int input : invalidInput) {
            assertThatThrownBy(() -> winningNumber.setBonusNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}