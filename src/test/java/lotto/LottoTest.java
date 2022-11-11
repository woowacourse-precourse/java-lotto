package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static lotto.Rank.*;
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

    @DisplayName("로또 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("camp.nextstep.edu.missionutils.Randoms 테스트")
    @Test
    void createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("발행번호, 당첨번호 몇 개의 숫자가 같은지 개수 세기")
    @Test
    void 발행번호_당첨번호_일치_개수_테스트() {
        Referee referee = new Referee();
        Lotto computerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int count = referee.correctNumberCount(computerLotto, myLotto);
        assertThat(5).isEqualTo(count);
    }

    @DisplayName("서로 다른 임의의 수 당첨번호(6개), 보너스볼(1개)와 발행한 로또 번호(6자리)를 비교하여 개수 증가")
    @Test
    void 당첨번호_보너스볼과_발행번호_비교하여_개수증가_테스트() {
        Referee referee = new Referee();
        Lotto computerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int input_bonus = 7;
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int correctNumberCount = referee.correctNumberCount(computerLotto, myLotto);

        referee.plusCorrectNumberCount(correctNumberCount, myLotto, input_bonus);
        assertThat(1).isEqualTo(FIVE_BONUS.getCount());
    }

    @DisplayName("보너스볼 숫자가 당첨번호에 포함되어 있는지 여부")
    @Test
    void 보너스볼_중복_체크_테스트() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int input_bonus = 6;
        assertThatThrownBy(() -> Exception.validateBonusBall(input_bonus, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨금액 구하기")
    @Test
    void 당첨금액_구하기_테스트() {
        Calculate calculate = new Calculate();
        THREE.plusCount();
        FOUR.plusCount();
        FOUR.plusCount();
        FIVE.plusCount();
        FIVE_BONUS.plusCount();
        SIX.plusCount();
        assertThat(2_031_605_000L).isEqualTo(calculate.getLotteryWinningPrize());

    }

    @DisplayName("총 수익률 구하기")
    @Test
    void 총_수익률_구하기_테스트() {
        Calculate calculate = new Calculate();
        THREE.plusCount();
        long lotteryWinningPrize = calculate.getLotteryWinningPrize();
        long payMoney = 8000L;
        double totalLotteryWinningPrizeProfit = calculate.getTotalLotteryWinningPrizeProfit(lotteryWinningPrize, payMoney);
        assertThat(62.5).isEqualTo(totalLotteryWinningPrizeProfit);
    }
}
