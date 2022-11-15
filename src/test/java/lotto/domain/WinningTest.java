package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkWinningNumberIsNotNumeric() {
        assertThatThrownBy(() -> new Money("100d0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
