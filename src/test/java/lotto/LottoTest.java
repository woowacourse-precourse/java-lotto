package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 번호에 범위를 초과한 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createDuplicatedWinBonus() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 45), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 비교한다.")
    @Test
    void matchWinNumber() {
        Lotto lotto = new Lotto(List.of(7, 5, 4, 3, 2, 1));
        new Lotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Integer matchWin = lotto.matchWinNumbers();
        assertEquals(5, matchWin);
    }

    @DisplayName("보너스 번호를 비교한다.")
    @Test
    void matchBonusNumber() {
        Lotto lotto = new Lotto(List.of(7, 5, 4, 3, 2, 1));
        new Lotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Boolean matchBonus = lotto.matchBonusNumber();
        assertEquals(true, matchBonus);
    }
}
