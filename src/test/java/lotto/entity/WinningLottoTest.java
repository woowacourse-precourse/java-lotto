package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 정해진 시작 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfStartRangeBonus() {
        //given
        int bonus = 0;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 정해진 끝 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfEndRangeBonus() {
        //given
        int bonus = 46;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 숫자를 가지면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateLottoNumber() {
        //given
        int bonus = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isInstanceOf(
            IllegalArgumentException.class);
    }

}