package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 숫자가 당첨 번호과 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberInWinningNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), new BonusNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}