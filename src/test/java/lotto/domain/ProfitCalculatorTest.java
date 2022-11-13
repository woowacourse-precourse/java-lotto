package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProfitCalculatorTest {

    @DisplayName("수익률 계산하기")
    @Test
    void getRateOfReturn() {
        LottoMachine lottoMachine = new LottoMachine();
        ProfitCalculator manager = new ProfitCalculator();
        lottoMachine.purchaseLottoTable(8000);
        float result = manager.getRateOfReturn(List.of(1,0,0,0,0));

        assertThat(result).isEqualTo(62.5f);
    }
}


