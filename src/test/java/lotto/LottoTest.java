package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Ranking.*;
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

    @DisplayName("일치하는 번호 개수와 보너스 번호 포함 여부를 통해, 각 등수를 구한다.")
    @Test
    void getRanking() {
        // when
        Game game = new Game();

        // then
        assertThat(game.valueOf(6,false)).isEqualTo(FIRST);
        assertThat(game.valueOf(6,true)).isEqualTo(FIRST);
        assertThat(game.valueOf(5,  true)).isEqualTo(SECOND);
        assertThat(game.valueOf(5,  false)).isEqualTo(THIRD);
        assertThat(game.valueOf(4,  false)).isEqualTo(FORTH);
        assertThat(game.valueOf(2, false)).isEqualTo(null);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여, 각 등수 당 당첨 개수를 구한다.")
    @Test
    void compareLotteries() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));    // 1등
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));    // 2등
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));    // 3등
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 5, 6, 8));    // 3등
        Lotto lotto5 = new Lotto(List.of(1, 2, 10, 14, 15, 18));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> lotteries = List.of(lotto1, lotto2, lotto3, lotto4, lotto5);

        // when
        Game game = new Game();
        game.compareAll(lotteries, winningNumber,bonusNumber);

        // then
        assertThat(game.compareAll(lotteries, winningNumber,bonusNumber).get(Ranking.FIRST)).isEqualTo(1);
        assertThat(game.compareAll(lotteries, winningNumber,bonusNumber).get(Ranking.SECOND)).isEqualTo(1);
        assertThat(game.compareAll(lotteries, winningNumber,bonusNumber).get(Ranking.THIRD)).isEqualTo(2);
        assertThat(game.compareAll(lotteries, winningNumber,bonusNumber).get(Ranking.FORTH)).isEqualTo(0);
        assertThat(game.compareAll(lotteries, winningNumber,bonusNumber).get(Ranking.FIFTH)).isEqualTo(0);
    }


}
