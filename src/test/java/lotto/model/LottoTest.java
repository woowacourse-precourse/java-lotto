package lotto.model;

import lotto.model.Lotto;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 범위를 넘어간 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호와 일치하는 번호의 수를 확인한다.")
    @Test
    void testCountMatched(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.countMatched(winningNumbers)).isEqualTo(5);
    }

    @DisplayName("보너스 번호와 일치하는 로또 번호의 수를 확인한다.")
    @Test
    void testContains(){
        Integer bonus = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.countBonus(bonus)).isEqualTo(1);
    }

    @DisplayName("로또의 당첨 순위 테스트")
    @Test
    public void rankTest(){
        Game game = new Game();
        game.setWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        game.setBonus(7);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        assertThat(lotto.getRank(game.getWinningLotto().getNumbers(), game.getBonus())).isEqualTo(Rank.SECOND);
    }


}
