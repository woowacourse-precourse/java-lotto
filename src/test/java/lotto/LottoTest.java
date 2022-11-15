package lotto;

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.LOTTO_SIZE_MISMATCH_MESSAGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.LOTTO_IS_NOT_UNIQUE_MESSAGE);
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createLottoByOverLottoNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.LOTTO_NUMBER_RANGE_MISMATCH_MESSAGE);
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderLottoNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.LOTTO_NUMBER_RANGE_MISMATCH_MESSAGE);
    }

    @DisplayName("당첨 로또와 사용자 로또와의 일치 개수가 4개일 경우 일치 개수 4를 반환한다")
    @Test
    void matchLottoWithWinningLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 7, 8), 9);

        assertThat(lotto.match(winningLotto)).isEqualTo(4);
    }

    @DisplayName("사용자 로또와 보너스 번호가 일치할 경우 참을 반환한다")
    void matchBonusWithLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThat(lotto.matchBonus(bonusNumber)).isTrue();
    }

    @DisplayName("사용자 로또와 보너스 번호가 일치하지 않을 경우 거짓을 반환한다")
    void dismatchBonusWithLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertThat(lotto.matchBonus(bonusNumber)).isFalse();
    }
}
