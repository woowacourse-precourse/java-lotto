package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("당첨 로또 번호 리스트가 보너스 번호를 포함하고 있는 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByWinningLottoContainsBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Bonus(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
