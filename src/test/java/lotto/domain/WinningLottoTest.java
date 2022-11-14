package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("입력된 당첨 번호 중 1 ~ 45의 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputWinningNumbersByOutOfBound() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 46, 4, 5, 6), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1 ~ 45 범위의 숫자여야 합니다.");
    }
}
