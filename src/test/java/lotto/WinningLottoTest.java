package lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateBonusNumber() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class Match {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        @DisplayName("로또 번호가 모두 같을 때")
        @Test
        void winningLottoMatchAll() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            assertEquals(winningLotto.match(lotto), 6);
        }

        @DisplayName("로또 번호가 모두 다를 때")
        @Test
        void winningLottoMatchNone() {
            Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
            assertEquals(winningLotto.match(lotto), 0);
        }

        @DisplayName("로또 번호가 3개만 같을 때")
        @Test
        void winningLottoMatch3() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 40, 41, 42));
            assertEquals(winningLotto.match(lotto), 3);
        }
    }

    @Nested
    class CheckBonus {
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber);

        @DisplayName("보너스 번호가 있을 때")
        @Test
        void hasBonusNumber() {
            Lotto lotto = new Lotto(List.of(bonusNumber, 9, 10, 11, 12, 13));
            assertEquals(winningLotto.checkBonus(lotto), true);
        }

        @DisplayName("보너스 번호가 없을 때")
        @Test
        void NoBonusNumber() {
            Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
            assertEquals(winningLotto.checkBonus(lotto), false);
        }
    }
}
