package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @DisplayName("당첨 번호에 보너스 번호가 포함되면 예외가 발생한다.")
    @Test
    void createWinningResultByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위 밖이면 예외가 발생한다.")
    @Test
    void createWinningResultByRange() {
        assertThatThrownBy(() -> new WinningResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 55))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 범위 밖의 숫자가 포함되어 있습니다.");
    }
}