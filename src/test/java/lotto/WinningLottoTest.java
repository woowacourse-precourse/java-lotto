package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void 당첨_로또_테스트() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getNumbers().size()).isEqualTo(6);
        assertThat(winningLotto.getBonus()).isEqualTo(7);
    }
}