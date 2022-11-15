package lotto.domain;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class YieldTest {
    @DisplayName("수익금을 올바르게 계산한다.")
    @Test
    void getTotalWinningPrice() {
        List<Grade> grades = List.of(Grade.SECOND, Grade.THIRD);
        int totalInvestment = 8_000;
        Yield yield = new Yield(grades,totalInvestment);

        assertThat(yield.getTotalWinningPrice()).isEqualTo(31_500_000);
    }

    @DisplayName("수익률을 올바르게 계산한다.")
    @Test
    void getYield() {
        List<Grade> grades = List.of(Grade.SECOND, Grade.THIRD);
        int totalInvestment = 8_000;
        Yield yield = new Yield(grades,totalInvestment);

        assertThat(yield.getYield()).isEqualTo("393750.0%");
    }
}
