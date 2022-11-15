package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6));
    @DisplayName("보너스 번호 입력 시 1부터 45까지의 숫자인지 확인한다.")
    @Test
    void inputInvalidBonusNumber() {
        int[] invalidInput = {46, -1};
        for (int input : invalidInput) {
            assertThatThrownBy(() -> winningNumber.setBonusNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("보너스 번호 입력 시 당첨 번호와 겹치는지 확인한다")
    @Test
    void testBonusNumberIsUnique() {
        assertThatThrownBy(() -> winningNumber.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}