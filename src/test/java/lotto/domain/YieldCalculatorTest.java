package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static lotto.prizestandards.PrizeStandards.*;
import static org.junit.jupiter.api.Assertions.*;

class YieldCalculatorTest {
    private YieldCalculator yieldCalculator;

    @BeforeEach
    void setUp() {
        yieldCalculator = new YieldCalculator();
    }

    @AfterEach
    void tearDown() {
        yieldCalculator = null;
    }

    @Test
    void computeYield() {
        int buyingMoney = 8000;
        Map<Enum, Integer> winnerResult = Map.of(
                THREE_MATCH, 1,
                FOUR_MATCH, 0,
                FIVE_MATCH, 0,
                FIVE_BONUS, 0,
                SIX_MATCH, 0,
                UNDER_PRIZE, 7
        );

        double prizeMoney = yieldCalculator.computeYield(buyingMoney, winnerResult);

        Assertions.assertThat(prizeMoney).isEqualTo(62.5);
    }
}