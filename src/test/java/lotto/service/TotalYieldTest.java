package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TotalYieldTest {
    TotalYield totalYield;

    @BeforeEach
    public void setUp() {
        totalYield = new TotalYield(8000, 5000);
    }

    @Test
    public void getYield() {
        double yield = totalYield.getYield();
        Assertions.assertThat(yield).isEqualTo(62.5);
    }
}
