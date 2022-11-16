package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("보너스번호가 중복이면 예외를 던진다.")
    @Test
    public void bonusNumberAlreadyExists() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호가 당첨 번호와 중복됩니다.");
    }
}