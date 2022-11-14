package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 숫자가 1부터 45사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 900)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 구입 금액으로 구입할 수 있는 개수의 로또를 구입합니다.")
    @Test
    void generateSixLotteries() {
        final int lotteryQuantity = 6;
        assertThat(Lotto.generateLotteries(lotteryQuantity).size())
                .isEqualTo(lotteryQuantity);
    }

    @DisplayName("로또 번호들과 당첨 번호, 보너스 번호를 비교하여 등수 별로 몇 개의 로또가 당첨됐는지 반환합니다.")
    @Test
    void getPrizes() {
        final List<List<Integer>> lotteries = new ArrayList<>();
        lotteries.add(List.of(1,2,3,4,5,6));
        lotteries.add(List.of(7,8,9,10,11,12));
        lotteries.add(List.of(1,3,5,7,9,11));
        lotteries.add(List.of(2,4,6,8,10,12));

        final List<Integer> jackpot = List.of(1,2,3,4,5,6);

        final int bonus = 7;

        assertThat(Lotto.getPrizes(lotteries, jackpot, bonus))
                .isEqualTo(List.of(2,0,0,0,1));
    }

    @DisplayName("당첨 결과를 기반으로 수익률을 계산하여 반환합니다.")
    @Test
    void calculateEarningRate() {
        final List<Integer> result = List.of(0,0,0,0,1);

        final int budget = 10000;

        assertThat(Lotto.getEarningRate(budget, result))
                .isEqualTo(20000000);
    }
}
