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
        Lottos lottos = Lottos.purchaseFor(money);

        assertThat(lottos.countTotal()).isEqualTo(money / lottoPrice);
    }

    @DisplayName("구입 금액은 1,000원 단위로 나누어 떨어져야 한다.")
    @Test
    void createLottosWithIndivisibleMoney() {
        int money = 5100;

        assertThatThrownBy(() -> Lottos.purchaseFor(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_LEFT_OVER);

    }

    @DisplayName("수익률을 계산하는 기능")
    @Test
    void calculateProfit() {
        Lottos lottos = new Lottos(
                Lotto.of(List.of(1, 2, 3, 4, 44, 45)),
                Lotto.of(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.of(List.of(1, 2, 7, 8, 9, 10))
        );
        Lotto winningLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        double profit = lottos.calculateProfit(winningLotto, bonusNumber);

        assertThat(String.format("%.1f%%", profit)).isEqualTo("1666.7%");
    }

    @DisplayName("등수별 당첨 횟수를 세는 기능")
    @Test
    void countWinningPirzes() {
        Lottos lottos = new Lottos(
                Lotto.of(List.of(1, 2, 3, 4, 44, 45)),
                Lotto.of(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.of(List.of(1, 2, 7, 8, 9, 10))
        );
        Lotto winningLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Map<LottoResult, Integer> winningCounts = lottos.getWinningCounts(winningLotto, bonusNumber);

        assertThat(winningCounts.get(LottoResult.FOURTH_PLACE)).isEqualTo(1);
        assertThat(winningCounts.get(LottoResult.FIRST_PLACE)).isEqualTo(0);
    }
}