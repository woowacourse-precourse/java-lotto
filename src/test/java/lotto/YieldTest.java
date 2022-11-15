package lotto;

import lotto.object.Yield;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YieldTest {
    @DisplayName("원금과 수익이 주어지면 올바른 수익률을 구해야 한다.")
    @Test
    void createYield() {
        Yield yield = new Yield(2000L, 6000L);

        assertThat(yield.getYield()).isEqualTo(300.0f);
    }
}
