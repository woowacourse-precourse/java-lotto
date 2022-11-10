package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 로또_번호들_중_당첨의_수를_카운트합니다() {
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
    void 총_수익을_계산합니다() {
        Calculator calculator = new Calculator();
        List<Integer> matchResults = List.of(1, 0, 1, 0, 0);

        assertThat(calculator.calculateProfit(matchResults))
                .isEqualTo(1505000);
    }
}