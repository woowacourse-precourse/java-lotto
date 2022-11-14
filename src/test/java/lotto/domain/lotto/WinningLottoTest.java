package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("[예외 발생] 보너스 숫자가 로또 당첨 번호 6개 중에 포함되어 있다면 IllegalArgumentException 예외 발생")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 3))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
