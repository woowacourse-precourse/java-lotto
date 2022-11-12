package lotto;

import lotto.domain.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinLottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinLottoByOverSize() {
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
    @Test
    void createWinLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new WinLotto("-45, -1, 0, 1, 45, 46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 1부터 45 사이의 숫자여야 한다.")
    @Test
    void createBonusByOutOfRangeNumber() {
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6").validateBonus("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6").validateBonus("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
