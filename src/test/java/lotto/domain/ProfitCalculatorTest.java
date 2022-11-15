package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {
    @DisplayName("수익률 계산하기")
    @Test
    void getRateOfProfit() {
        LottoMachine lottoMachine = new LottoMachine();
        ProfitCalculator profitCalculator = new ProfitCalculator();
        lottoMachine.purchaseLottoTable(8000);
        float result = profitCalculator.toRateOfProfit(List.of(1,0,0,0,0,8));

        assertThat(result).isEqualTo(62.5f);
    }
}


