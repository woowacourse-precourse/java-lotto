package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculatorTest {

    @DisplayName("티켓 8매로 5등 1개면 수익률은 62.5다")
    @Test
    void createOneFifthPrizeBy14000() {
        Assertions.assertThat(new Calculator(8, List.of(Prize.FIFTH)).profit())
                .isEqualTo(62.5);
    }
}
