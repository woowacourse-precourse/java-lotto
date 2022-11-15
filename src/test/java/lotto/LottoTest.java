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
        assertThat(game.valueOf(6, false)).isEqualTo(FIRST);
        assertThat(game.valueOf(6, true)).isEqualTo(FIRST);
        assertThat(game.valueOf(5, true)).isEqualTo(SECOND);
        assertThat(game.valueOf(5, false)).isEqualTo(THIRD);
        assertThat(game.valueOf(4, false)).isEqualTo(FORTH);
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
        game.compareAll(lotteries, winningNumber, bonusNumber);

        // then
        assertThat(game.compareAll(lotteries, winningNumber, bonusNumber).get(Ranking.FIRST)).isEqualTo(1);
        assertThat(game.compareAll(lotteries, winningNumber, bonusNumber).get(Ranking.SECOND)).isEqualTo(1);
        assertThat(game.compareAll(lotteries, winningNumber, bonusNumber).get(Ranking.THIRD)).isEqualTo(2);
        assertThat(game.compareAll(lotteries, winningNumber, bonusNumber).get(Ranking.FORTH)).isEqualTo(0);
        assertThat(game.compareAll(lotteries, winningNumber, bonusNumber).get(Ranking.FIFTH)).isEqualTo(0);
    }

    @DisplayName("로또 구입 금액을 잘못 입력한 경우 예외가 발생한다.")
    @Test
    void inputMoneyError() {
        // given
        int money = 1100;   // [ERROR] 1000으로 나눠지지 않는 경우

        // then
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
        ;
    }

    @DisplayName("구입 금액에 따라 로또를 발행한다.")
    @Test
    void createLotteries() {
        // given
        String money = "10000";

        // when
        Game game = new Game();
        game.setLotteries(money);

        // then
        assertThat(game.getLotteries().stream()
                .map(Lotto::getNumbers)
                .count())
                .isEqualTo(10);
    }

    @DisplayName("입력된 당첨 번호 또는 보너스 번호가 1~45 범위에서 벗어나면 예외가 발생한다.")
    @Test
    void inputNumbersError() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 17;

        // when
        Lotto winningNumber = new Lotto(winningNumbers);

        // then
        assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호에 중복 숫자가 존재하면 예외가 발생한다.")
    @Test
    void inputWinningNumbersDuplicated() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 6;

        // when
        Lotto winningNumber = new Lotto(winningNumbers);

        // then
        assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void inputBonusNumbersDuplicated() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when
        Lotto winningNumber = new Lotto(winningNumbers);

        // then
        assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호로 중복되지 않는 숫자 6개를 입력 받고, 보너스 번호 1개를 입력 받는다.")
    @Test
    void inputWinningNumbers() {
        // given
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        // when
        Game game = new Game();

        // then
        assertThat(game.inputNumber(winningNumbers, bonusNumber).getWinningNumber().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(game.inputNumber(winningNumbers, bonusNumber).getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("당첨 금액과 구입 금액을 이용하여 수익률을 구한다.")
    @Test
    void getAmountPercent() {
        // given
        double winPrize = 5000;

        // when
        Game game = new Game();
        game.setMoney("8000");
        game.earningsPercent(winPrize);

        // then
        assertThat(game.earningsPercent(winPrize)).isEqualTo(62.5);
    }


}
