package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {

    List<Lotto> lottos;

    Referee referee;

    @BeforeEach
    void init() {
        lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        referee = new Referee();
    }

    @DisplayName("총상금을 반환.")
    @Test
    void totalPrize() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Profit profit = new Profit(winningStats);

        // when
        long result = profit.totalPrize();

        // then
        assertThat(result).isEqualTo(5_000);
    }

    @DisplayName("총상금을 반환. - 총상금 0원인 경우")
    @Test
    void totalPrizeIsZero() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 6, 37);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Profit profit = new Profit(winningStats);

        // when
        long result = profit.totalPrize();

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("구입금액과 당첨 금액의 비율 반환")
    @Test
    void toRate() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Profit profit = new Profit(winningStats);
        Quantity quantity = new Quantity(8_000);
        long totalPrize = profit.totalPrize();

        // when
        double result = profit.toRate(quantity, totalPrize);

        // then
        assertThat(result).isEqualTo(0.625);
    }

    @DisplayName("구입금액과 당첨 금액의 비율 반환 - 총상금이 0원인 경우")
    @Test
    void toRateIsZero() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 6, 37);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Profit profit = new Profit(winningStats);
        Quantity quantity = new Quantity(8_000);
        long totalPrize = profit.totalPrize();

        // when
        double result = profit.toRate(quantity, totalPrize);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("백분율로 변환")
    @Test
    void toPercent() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Profit profit = new Profit(winningStats);
        Quantity quantity = new Quantity(8_000);
        long totalPrize = profit.totalPrize();
        double rate = profit.toRate(quantity, totalPrize);

        // when
        double result = profit.toPercent(rate);

        // then
        assertThat(result).isEqualTo(62.5);
    }

    @DisplayName("소수점 둘쨰자리에서 반올림한 결과를 반환")
    @Test
    void roundUpSecondDigit() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Profit profit = new Profit(winningStats);
        Quantity quantity = new Quantity(8_000);
        long totalPrize = profit.totalPrize();
        double rate = profit.toRate(quantity, totalPrize);
        double percent = profit.toPercent(rate);

        // when
        double result = profit.roundUpSecondDigit(percent);

        // then
        assertThat(result).isEqualTo(62.5);
    }

    @DisplayName("수익률을 반환1")
    @Test
    void calculate() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Quantity quantity = new Quantity(8_000);
        Profit profit = new Profit(winningStats);

        // when
        double result = profit.calculate(quantity);

        // then
        assertThat(result).isEqualTo(62.5);
    }

    @DisplayName("수익률을 반환2")
    @Test
    void calculate2() {
        // given
        lottos = List.of(
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Quantity quantity = new Quantity(3_000);
        Profit profit = new Profit(winningStats);

        // when
        double result = profit.calculate(quantity);

        // then
        assertThat(result).isEqualTo(166.7);
    }

    @DisplayName("수익률을 반환3")
    @Test
    void calculate3() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 6, 37);
        int bonusNumber = 7;
        List<WinningStat> winningStats = referee.compare(lottos, player, bonusNumber);
        Quantity quantity = new Quantity(8_000);
        Profit profit = new Profit(winningStats);

        // when
        double result = profit.calculate(quantity);

        // then
        assertThat(result).isEqualTo(0);
    }
}