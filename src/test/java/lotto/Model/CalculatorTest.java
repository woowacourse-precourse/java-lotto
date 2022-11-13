package lotto.Model;

import static lotto.Model.WinningRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    List<WinningRank> rank = List.of(SECOND, SIXTH, SIXTH, SIXTH, FIFTH, FIFTH);
    Calculator calculator = new Calculator(rank);

    @DisplayName("로또 총 당첨금을 계산한다")
    @Test
    void calculateWinningAmount() {
        long result = calculator.getSumOfWinningAmount();
        assertThat(result).isEqualTo(30_010_000);
    }
    @DisplayName("로또 당첨 개별 개수를 계산한다.")
    @Test
    void calculateWinningCount() {
        int result = calculator.CountOfRank(FIFTH);
        assertThat(result).isEqualTo(2);
    }
}
