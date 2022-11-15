package lotto.domain;

import lotto.domain.exception.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("당첨 로또 번호 리스트가 보너스 번호를 포함하고 있는 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByWinningLottoContainsBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
