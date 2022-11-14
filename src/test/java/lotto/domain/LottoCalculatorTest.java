package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    @DisplayName("당첨 금액을 더한다")
    @Test
    void prizeToMoneyTest() {
        List<LottoPrize> lottoPrizes = new ArrayList<>(List.of(LottoPrize.FIFTH, LottoPrize.FIRST));
        Money money = LottoCalculator.sumAllPrize(lottoPrizes);

        Assertions.assertThat(money).isEqualTo(Money.of(2000005000));
    }

    @DisplayName("수익률을 구한다.")
    @Test
    void getRatio() {
        List<LottoPrize> lottoPrizes = new ArrayList<>(List.of(LottoPrize.FIFTH));
        double profitRate = LottoCalculator.getProfitRate(new User(8000), lottoPrizes);

        Assertions.assertThat(profitRate).isEqualTo(62.5);
    }
}