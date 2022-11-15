package lotto;

import lotto.logic.Calculator;
import lotto.model.WinningRank;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 수익_계산() {
        Calculator calculator = new Calculator();
        Map<WinningRank, Integer> enumMap = new EnumMap<WinningRank, Integer>(WinningRank.class);
        enumMap.put(WinningRank.one, 1);
        assertThat(calculator.getProfit(enumMap)).isEqualTo(WinningRank.one.getPrize());
    }

    @Test
    void 수익률_계산() {
        Calculator calculator = new Calculator();
        Map<WinningRank, Integer> enumMap = new EnumMap<WinningRank, Integer>(WinningRank.class);
        enumMap.put(WinningRank.five, 1);
        assertThat(calculator.getEarningsRate(8000, enumMap)).isEqualTo(62.5);
    }
}
