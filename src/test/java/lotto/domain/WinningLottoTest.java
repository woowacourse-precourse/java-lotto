package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class WinningLottoTest {

    @DisplayName("당첨 번호에 1~45 범위 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByInvalidRangeNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 50), 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 이외의 숫자이면 예외가 발생한다.")
    @Test
    void createWinningLottoByInvalidRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 1등 당첨 내용을 반환한다.")
    @Test
    void compareWithFirstPlaceLotto() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto playerLotto = new Lotto(List.of(1,2,3,4,5,6));

        Rank rank = winningLotto.compare(playerLotto);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 2등 당첨 내용을 반환한다.")
    @Test
    void compareWithSecondPlaceLotto() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Lotto playerLotto = new Lotto(List.of(1,2,3,4,5,7));

        Rank rank = winningLotto.compare(playerLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}