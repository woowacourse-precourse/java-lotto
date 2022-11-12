package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckLottoTest {
    private final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("당첨 로또와 일치하는 숫자는 3개이다.")
    @Test
    void matchThree() {
        CheckLotto winningLotto = new CheckLotto(List.of(1, 22, 3, 44, 5, 66), 2);
        assertThat(winningLotto.match(List.of(userLotto)).get(WinningNumber.THREE_MATCHES)).isEqualTo(1);
    }

    @DisplayName("당첨 로또와 일치하는 숫자는 4개이다.")
    @Test
    void matchFour() {
        CheckLotto winningLotto = new CheckLotto(List.of(1, 2, 3, 44, 5, 66), 24);
        assertThat(winningLotto.match(List.of(userLotto)).get(WinningNumber.FOUR_MATCHES)).isEqualTo(1);
    }

    @DisplayName("당첨 로또와 일치하는 숫자는 5개이다.")
    @Test
    void matchFive() {
        CheckLotto winningLotto = new CheckLotto(List.of(1, 2, 3, 4, 5, 66), 24);
        assertThat(winningLotto.match(List.of(userLotto)).get(WinningNumber.FIVE_MATCHES)).isEqualTo(1);
    }

    @DisplayName("당첨 로또와 일치하는 숫자는 5개이고, 보너스 숫자도 일치한다.")
    @Test
    void matchFiveAndBonusNumber() {
        CheckLotto winningLotto = new CheckLotto(List.of(1, 2, 3, 4, 5, 66), 6);
        assertThat(winningLotto.match(List.of(userLotto)).get(WinningNumber.FIVE_AND_BONUS_BALL_MATCHES)).isEqualTo(1);
    }

    @DisplayName("당첨 로또와 일치하는 숫자는 6개이다.")
    @Test
    void matchSix() {
        CheckLotto winningLotto = new CheckLotto(List.of(1, 2, 3, 4, 5, 6), 2);
        assertThat(winningLotto.match(List.of(userLotto)).get(WinningNumber.SIX_MATCHES)).isEqualTo(1);
    }
}