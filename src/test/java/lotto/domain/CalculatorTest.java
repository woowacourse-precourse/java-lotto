package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    final Calculator calculator = new Calculator();

    @Nested
    class df {

        @DisplayName("수익률 계산 -> 0 퍼센트일때")
        @Test
        void case1() {
            final List<Integer> totalReward = List.of(0);
            final int money = 1000;

            assertEquals(0, calculator.df(totalReward, money));
        }

        @DisplayName("수익률 계산 -> 100퍼센트")
        @Test
        void case2() {
            final List<Integer> totalReward = List.of(1000);
            final int money = 1000;

            assertEquals(100, calculator.df(totalReward, money));
        }
    }


}