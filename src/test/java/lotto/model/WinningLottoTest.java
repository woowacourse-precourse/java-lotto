package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7),10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 1~45 사이의 숫자가 아닌 다른 숫자가 들어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByNotInEffectiveRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 47), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 보너스 숫자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoNumbersContainsBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호를 기준으로 당첨된 로또 개수를 올바르게 센다..")
    @Test
    void countMatchingLottoWithWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int matchingCount = winningLotto.countMatchingLottoNumbers(lotto);

        Assertions.assertThat(matchingCount).isEqualTo(6);
    }

    @DisplayName("보너스 번호를 가지고 있는 경우 true 가 된다.")
    @Test
    void haveBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        boolean hasBonusNumber = winningLotto.matchBonusNumber(lotto);

        Assertions.assertThat(hasBonusNumber).isTrue();
    }

    @DisplayName("보너스 번호를 가지고 있지 않은 경우 false 가 된다.")
    @Test
    void haveNoBonusNumber() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        boolean hasBonusNumber = winningLotto.matchBonusNumber(lotto);

        Assertions.assertThat(hasBonusNumber).isFalse();
    }
}