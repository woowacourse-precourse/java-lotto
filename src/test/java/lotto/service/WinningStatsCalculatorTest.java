package lotto.service;

import static java.util.Map.entry;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningStatsCalculatorTest {

    WinningStatsCalculator calculatorCreator(List<Lotto> lottoNumbers, Lotto winningNumber,
                                             int bonusNumber, long purchaseAmount) {
        return new WinningStatsCalculator(lottoNumbers, winningNumber, bonusNumber, purchaseAmount);
    }

    @Test
    void 당첨_안됨() {
        WinningStatsCalculator winningStatsCalculator = calculatorCreator(
                List.of(new Lotto(List.of(7, 8, 9, 10, 11, 12))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7,
                1);

        Assertions.assertThat(winningStatsCalculator.getWinningStats())
                .contains(entry(0, 1L));

        Assertions.assertThat(winningStatsCalculator.getReturnRate())
                .isEqualTo(0);
    }

    @Test
    void FIRST_PRIZE_당첨() {
        WinningStatsCalculator winningStatsCalculator = calculatorCreator(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7,
                1);

        Assertions.assertThat(winningStatsCalculator.getWinningStats())
                .hasSize(1)
                .contains(entry(1, 1L));

        Assertions.assertThat(winningStatsCalculator.getReturnRate())
                .isEqualTo(200000000);
    }

    @Test
    void SECOND_PRIZE_당첨() {
        WinningStatsCalculator winningStatsCalculator = calculatorCreator(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7,
                1);

        Assertions.assertThat(winningStatsCalculator.getWinningStats())
                .hasSize(1)
                .contains(entry(2, 1L));

        Assertions.assertThat(winningStatsCalculator.getReturnRate())
                .isEqualTo(3000000);
    }

    @Test
    void THIRD_PRIZE_당첨() {
        WinningStatsCalculator winningStatsCalculator = calculatorCreator(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7,
                1);

        Assertions.assertThat(winningStatsCalculator.getWinningStats())
                .hasSize(1)
                .contains(entry(3, 1L));

        Assertions.assertThat(winningStatsCalculator.getReturnRate())
                .isEqualTo(150000);
    }

    @Test
    void FOURTH_PRIZE_당첨() {

        WinningStatsCalculator winningStatsCalculator = calculatorCreator(
                List.of(new Lotto(List.of(1, 2, 3, 4, 7, 8))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7,
                1);

        Assertions.assertThat(winningStatsCalculator.getWinningStats())
                .hasSize(1)
                .contains(entry(4, 1L));

        Assertions.assertThat(winningStatsCalculator.getReturnRate())
                .isEqualTo(5000);
    }

    @Test
    void FIFTH_PRIZE_당첨() {
        WinningStatsCalculator winningStatsCalculator = calculatorCreator(
                List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9))),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7,
                1);

        Assertions.assertThat(winningStatsCalculator.getWinningStats())
                .hasSize(1)
                .contains(entry(5, 1L));

        Assertions.assertThat(winningStatsCalculator.getReturnRate())
                .isEqualTo(500);
    }

}