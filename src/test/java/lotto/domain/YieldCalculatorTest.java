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
                THREEMATCH, 1,
                FOURMATCH, 0,
                FIVEMATCH, 0,
                FIVEBONUS, 0,
                SIXMATCH, 0,
                UNDERPRIZE, 7
        );

        double prizeMoney = yieldCalculator.computeYield(buyingMoney, winnerResult);

        Assertions.assertThat(prizeMoney).isEqualTo(62.5);
    }
}