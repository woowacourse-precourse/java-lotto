package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByNotRangeNumber(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);


    }
    @Test
    void calculateMatchNumberTest(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,10,11,12),45);
        Assertions.assertThat(lotto.calculateMatchNumber(winningLotto).getMatchNumbers())
                .isEqualTo(3);
        Assertions.assertThat(lotto.calculateMatchNumber(winningLotto).isMatchBonusNumber())
                .isEqualTo(false);

        lotto = new Lotto(List.of(1,2,3,4,5,45));
        winningLotto = new WinningLotto(List.of(1,2,3,4,5,12),45);
        Assertions.assertThat(lotto.calculateMatchNumber(winningLotto).getMatchNumbers())
                .isEqualTo(5);
        Assertions.assertThat(lotto.calculateMatchNumber(winningLotto).isMatchBonusNumber())
                .isEqualTo(true);
    }

}
