package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다")
    void calculateMatchResults() {
        Calculator calculator = new Calculator();
        List<List<Integer>> groupOfUserLotteryNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(4, 6, 8, 14, 25, 36),
                List.of(4, 6, 10, 14, 25, 36),
                List.of(3, 6, 14, 25, 27, 44),
                List.of(4, 6, 14, 25, 36, 41)
        );
        List<Integer> winningNumbers = List.of(4, 6, 14, 25, 36, 41);
        int bonusNumber = 8;
        List<Integer> answer = List.of(1, 0, 1, 1, 1);

        List<Integer> matchResults = calculator.calculateMatchResults(groupOfUserLotteryNumbers, winningNumbers,
                bonusNumber);

        assertThat(matchResults)
                .isEqualTo(answer);
    }

    @Test
    @DisplayName("총 수익을 계산합니다")
    void calculateProfit() {
        Calculator calculator = new Calculator();
        List<Integer> matchResults = List.of(1, 0, 1, 0, 0);

        assertThat(calculator.calculateProfit(matchResults))
                .isEqualTo(1505000);
    }

    @Test
    @DisplayName("수익률을 계산합니다")
    void calculateEarningsRate() {
        Calculator calculator = new Calculator();
        int purchaseCost = 8000;
        int profit = 5000;

        assertThat(calculator.calculateEarningsRate(purchaseCost, profit))
                .isEqualTo(62.5);
    }
}