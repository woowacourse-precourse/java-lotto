package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    void setup() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 로또를 생성한다.")
    @Test
    void 당첨_로또와_생성_테스트() {
        int bonus = 7;
        winningLotto = new WinningLotto(lotto, bonus);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonus);
    }

    @DisplayName("보너스 숫자가 티켓 범위가 아니면 예외가 발생한다.")
    @Test
    void 보너스_생성_예외_테스트() {
        int bonus = 47;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}