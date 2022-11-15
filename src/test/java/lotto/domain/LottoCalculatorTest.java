package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @DisplayName("당첨 금액을 더한다")
    @Test
    void prizeToMoneyTest() {
        Map<LottoPrize, Integer> lottoPrizes = new HashMap<>(Map.of(LottoPrize.FIRST, 1, LottoPrize.FIFTH, 1));
        Money money = LottoCalculator.sumAllPrize(lottoPrizes);

        Assertions.assertThat(money).isEqualTo(Money.of(2000005000));
    }

    @DisplayName("수익률을 구한다.")
    @Test
    void getRatio() {
        Map<LottoPrize, Integer> lottoPrizes = new HashMap<>(Map.of(LottoPrize.FIFTH, 1));
        double profitRate = LottoCalculator.getProfitRate(new User(8000), lottoPrizes);

        Assertions.assertThat(profitRate).isEqualTo(62.5);
    }
}