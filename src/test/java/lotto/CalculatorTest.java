package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rank.initCount());
    }

    @Test
    void 전체_당첨금_계산() {
        assertThat(Calculator.getTotalPrize()).isEqualTo(0);

        Rank.ONE.plus();
        assertThat(Calculator.getTotalPrize())
                .isEqualTo(Rank.ONE.getPrize());

        Rank.TWO.plus();
        assertThat(Calculator.getTotalPrize())
                .isEqualTo(Rank.ONE.getPrize() +
                        Rank.TWO.getPrize());

        Rank.FIVE.plus();
        assertThat(Calculator.getTotalPrize())
                .isEqualTo(Rank.ONE.getPrize() +
                        Rank.TWO.getPrize() +
                        Rank.FIVE.getPrize());
    }

    @Test
    void 수익률_계산() {
        int buyPrice = 10000;
        float result = Calculator.getTotalPrize() / buyPrice * 100;

        float profit = Calculator.calculate(buyPrice);
        assertThat(result).isEqualTo(profit);
    }
}