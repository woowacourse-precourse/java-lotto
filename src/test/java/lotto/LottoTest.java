package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(-45, -1, 0, 1, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 getSameNumCount() 기능 테스트")
    @Test
    void testGetSameNumCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(2, 3, 6, 9, 12, 15));
        int result = 3;

        assertThat(lotto.getSameNumCount(otherLotto.getNumbers())).isEqualTo(result);
    }

    @DisplayName("로또 checkBonusNum() 기능 테스트")
    @Test
    void testBonusNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean result = true;

        assertThat(lotto.checkBonus(3)).isEqualTo(result);
    }
}