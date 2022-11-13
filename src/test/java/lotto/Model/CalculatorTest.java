package lotto.Model;

import static lotto.Model.WinningRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("로또 당첨금 계산")
    @Test
    void calculateWinningAmount() {
        List<WinningRank> rank = List.of(SECOND, SIXTH, SIXTH, SIXTH, SIXTH, FIFTH);
        Calculator calculator = new Calculator(rank);
        long result = calculator.getSumOfWinningAmount();
        assertThat(result).isEqualTo(30_005_000);
    }
}
