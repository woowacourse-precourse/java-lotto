package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void 당첨_로또_테스트() {
        WinningLotto winningLotto = WinningLotto.from(5, true);
        assertThat(winningLotto).isEqualTo(WinningLotto.SECOND);
    }
}
