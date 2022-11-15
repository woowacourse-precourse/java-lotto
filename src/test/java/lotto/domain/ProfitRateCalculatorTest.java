package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorTest {

  ProfitRateCalculator rateCalculator = new ProfitRateCalculator();

  @Test
  void 구매금액_1000_당첨금액_5000_비율500() {
    List<LottoPrize> lottoPrizes = List.of(LottoPrize.FIFTH);

    double calculate = rateCalculator.calculate(lottoPrizes);

    assertThat(calculate).isEqualTo(500.0);
  }

  @Test
  void 구매금액_8000원_당첨금액_5000_비율62_5() {
    List<LottoPrize> lottoPrizes = List.of(LottoPrize.FIFTH, LottoPrize.MATCH_NOTING,
        LottoPrize.MATCH_NOTING, LottoPrize.MATCH_NOTING, LottoPrize.MATCH_NOTING,
        LottoPrize.MATCH_NOTING, LottoPrize.MATCH_NOTING, LottoPrize.MATCH_NOTING);

    double calculate = rateCalculator.calculate(lottoPrizes);

    assertThat(calculate).isEqualTo(62.5);
  }

  @Test
  void 구매금액_3000원_당첨금액_55000원_반올림되어_1833_3() {
    List<LottoPrize> lottoPrizes = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH,
        LottoPrize.MATCH_NOTING);

    double calculate = rateCalculator.calculate(lottoPrizes);

    assertThat(calculate).isEqualTo(1833.3);
  }
}