package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.service.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {
    @DisplayName("2개 구매, 5,000원 당첨")
    @Test
    void case1() {
        List<List<Integer>> lottoTickets = List.of(
                List.of(3, 5, 11, 16, 32, 38),
                List.of(8, 21, 23, 41, 42, 43)
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 8, 21, 23);
        Integer bonusNumber = 7;

        List<Integer> expected = List.of(0, 5_000);
        List<Integer> actual = Calculator.produceProfit(lottoTickets, winningNumbers, bonusNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("3개 구매, 50,000원 당첨")
    @Test
    void case2() {
        List<List<Integer>> lottoTickets = List.of(
                List.of(3, 5, 11, 16, 32, 38),
                List.of(8, 21, 23, 41, 42, 43),
                List.of(7, 11, 16, 35, 36, 44)
        );
        List<Integer> winningNumbers = List.of(2, 3, 8, 21, 23, 41);
        Integer bonusNumber = 7;

        List<Integer> expected = List.of(0, 50_000, 0);
        List<Integer> actual = Calculator.produceProfit(lottoTickets, winningNumbers, bonusNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("4개 구매, 1,510,000원 당첨")
    @Test
    void case3() {
        List<List<Integer>> lottoTickets = List.of(
                List.of(2, 8, 21, 31, 44, 45),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 8, 21, 23, 42, 43),
                List.of(2, 3, 8, 21, 23, 44)
        );
        List<Integer> winningNumbers = List.of(2, 3, 8, 21, 23, 41);
        Integer bonusNumber = 7;

        List<Integer> expected = List.of(5_000, 0, 5_000, 1_500_000);
        List<Integer> actual = Calculator.produceProfit(lottoTickets, winningNumbers, bonusNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5개 구매, 30,005,000원 당첨 (보너스볼 일치)")
    @Test
    void case4() {
        List<List<Integer>> lottoTickets = List.of(
                List.of(2, 8, 21, 35, 44, 45),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(1, 8, 21, 26, 42, 43),
                List.of(1, 7, 10, 21, 23, 44),
                List.of(2, 3, 8, 21, 23, 7)
        );
        List<Integer> winningNumbers = List.of(2, 3, 8, 21, 23, 41);
        Integer bonusNumber = 7;

        List<Integer> expected = List.of(5_000, 0, 0, 0, 30_000_000);
        List<Integer> actual = Calculator.produceProfit(lottoTickets, winningNumbers, bonusNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("6개 구매, 2,003,015,000원 당첨 부럽다")
    @Test
    void case5() {
        List<List<Integer>> lottoTickets = List.of(
                List.of(2, 8, 21, 35, 44, 45),
                List.of(3, 8, 11, 16, 32, 41),
                List.of(2, 3, 8, 21, 42, 41),
                List.of(1, 7, 10, 21, 23, 44),
                List.of(3, 8, 21, 23, 41, 42),
                List.of(2, 3, 8, 21, 23, 41)
        );
        List<Integer> winningNumbers = List.of(2, 3, 8, 21, 23, 41);
        Integer bonusNumber = 7;

        List<Integer> expected = List.of(5_000, 5_000, 1_500_000, 0, 1_500_000, 2_000_000_000);
        List<Integer> actual = Calculator.produceProfit(lottoTickets, winningNumbers, bonusNumber);
        assertThat(actual).isEqualTo(expected);
    }
}