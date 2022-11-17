package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("구입한 금액만큼 로또를 반복적으로 발행한다.")
    @Test
    void createLottosForAmountOfMoney() {
        Money money = Money.of(5_000);
        Lottos lottos = Lottos.purchaseFor(money);

        assertThat(lottos.countTotal()).isEqualTo(money.countAvailable(Lotto.PRICE));
    }

    @DisplayName("수익률을 계산하는 기능")
    @Test
    void calculateProfit() {
        Lottos lottos = new Lottos(
                Lotto.of(List.of(1, 2, 3, 4, 44, 45)),
                Lotto.of(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.of(List.of(1, 2, 7, 8, 9, 10))
        );
        WinningLotto winningLotto = WinningLotto.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                7
        );

        LottoResult lottoResult = lottos.countNumberOfWins(winningLotto);
        double profit = lottoResult.calculateProfitRate();

        assertThat(String.format("%.1f%%", profit)).isEqualTo("1666.7%");
    }

    @DisplayName("등수별 당첨 횟수를 세는 기능")
    @Test
    void countWinning() {
        Lottos lottos = new Lottos(
                Lotto.of(List.of(1, 2, 3, 4, 44, 45)),
                Lotto.of(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.of(List.of(1, 2, 7, 8, 9, 10))
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(winningNumbers), 7);

        LottoResult lottoResult = lottos.countNumberOfWins(winningLotto);

        assertThat(lottoResult.winningCountsOf(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.winningCountsOf(Rank.FIRST)).isEqualTo(0);
    }
}