package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {
    @DisplayName("구입한 금액만큼 로또를 반복적으로 발행한다.")
    @Test
    void createLottosForAmountOfMoney() {
        int money = 5000;
        int lottoPrice = 1000;
        Lottos lottos = new Lottos(money);

        assertThat(lottos.countTotal()).isEqualTo(money / lottoPrice);
    }

    @DisplayName("구입 금액은 1,000원 단위로 나누어 떨어져야 한다.")
    @Test
    void createLottosWithIndivisibleMoney() {
        int money = 5100;
        int lottoPrice = 1000;

        assertThatThrownBy(() -> new Lottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_LEFT_OVER);

    }

    @DisplayName("수익률을 계산하는 기능")
    @Test
    void calculateProfit() {
        Lottos lottos = new Lottos(
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        double profit = lottos.calculateProfit(winningLotto, bonusNumber);

        assertThat(String.format("%.1f%%", profit)).isEqualTo("1666.7%");
    }

    @DisplayName("등수별 당첨 횟수를 세는 기능")
    @Test
    void countWinningPirzes() {
        Lottos lottos = new Lottos(
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Map<WinningPrize, Integer> winningPrizeCount = lottos.countWinningPrize(winningLotto, bonusNumber);

        assertThat(winningPrizeCount.get(WinningPrize.FOURTH_PLACE)).isEqualTo(1);
        assertThat(winningPrizeCount.get(WinningPrize.FIRST_PLACE)).isEqualTo(0);
    }
}