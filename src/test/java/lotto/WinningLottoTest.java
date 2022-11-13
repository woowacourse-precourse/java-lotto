package lotto;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinningLotto;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @DisplayName("당첨 로또를 생성합니다.")
    @Test
    void createLottoByDuplicatedNumber() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
        assertThat(winningLotto.getNumbers()).contains(1,2,3,4,5,6);
    }
}
