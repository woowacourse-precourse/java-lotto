package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfitCalculatorTest {

    @BeforeEach
    void setUp() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rank.initCount());
    }

    @Test
    void calculate_total_rewards() {
        assertThat(ProfitCalculator.getTotalReward()).isEqualTo(0);

        Rank.FIRST.plus();
        assertThat(ProfitCalculator.getTotalReward())
                .isEqualTo(Rank.FIRST.getReward());

        Rank.SECOND.plus();
        assertThat(ProfitCalculator.getTotalReward())
                .isEqualTo(Rank.FIRST.getReward() +
                        Rank.SECOND.getReward());

        Rank.FIFTH.plus();
        assertThat(ProfitCalculator.getTotalReward())
                .isEqualTo(Rank.FIRST.getReward() +
                        Rank.SECOND.getReward() +
                        Rank.FIFTH.getReward());
    }

    @Test
    void calculate_profit() {
        int buyPrice = 10000;
        float result = ProfitCalculator.getTotalReward() / buyPrice * 100;

        float profit = ProfitCalculator.calculate(buyPrice);
        assertThat(result).isEqualTo(profit);
    }

}
