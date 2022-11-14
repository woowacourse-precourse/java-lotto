package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createLottoOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,2,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 1등부터 5등 당첨 확인 및 당첨 안된 경우도 확인")
    @Test
    void createLottoRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.FIRST);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.SECOND);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.THIRD);

        lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.FOURTH);

        lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.FIFTH);

        lotto = new Lotto(List.of(10, 11, 13, 7, 8, 9));
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        assertThat(lotto.getRank(winningNumbers)).isEqualTo(Rank.NONE);

    }
}
