package lotto.Domain;

import static lotto.Domain.WinningRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    List<WinningRank> rank = List.of(FOURTH, SIXTH, SIXTH, SIXTH, SIXTH, SIXTH, FIFTH);
    Calculator calculator = new Calculator(rank);

    @DisplayName("로또 총 당첨금을 계산한다")
    @Test
    void calculateWinningAmount() {
        double result = calculator.getSumOfWinningAmount();
        assertThat(result).isEqualTo(55_000.0);
    }
    @DisplayName("로또 당첨 개별 개수를 계산한다.")
    @Test
    void calculateWinningCount() {
        int result = calculator.CountOfRank(FIFTH);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("총 수익율을 계산한다.")
    @Test
    void calculateEarnedRatio() {
        double result = Math.round(calculator.earnedRatio());
        assertThat(result).isEqualTo(786);
    }
}
