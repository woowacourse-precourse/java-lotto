package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsCalculatorTest {
    @DisplayName("로또 등수 개수 세기")
    @Test
    void countLottoPrize() {
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("1,2,3,4,5,6"));
            add(new Lotto("1,2,3,4,5,7"));
            add(new Lotto("1,2,3,4,5,8"));
            add(new Lotto("1,2,3,4,8,9"));
            add(new Lotto("1,2,3,8,9,10"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        HashMap<WinningHistory, Integer> result = new HashMap<>() {{
            put(WinningHistory.FIRST_PRIZE, 1);
            put(WinningHistory.SECOND_PRIZE, 1);
            put(WinningHistory.THIRD_PRIZE, 1);
            put(WinningHistory.FOURTH_PRIZE, 1);
            put(WinningHistory.FIFTH_PRIZE, 1);
            put(WinningHistory.BLANK, 0);
        }};

        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(winningStatisticsCalculator.getWinningHistory()).isEqualTo(result);
    }

    @DisplayName("로또 총 수익률 계산하기")
    @Test
    void calculateRateOfReturn() {
        int amount = 8000;
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("8, 21, 23, 41, 42, 43"));
            add(new Lotto("3, 5, 11, 16, 32, 38"));
            add(new Lotto("7, 11, 16, 35, 36, 44"));
            add(new Lotto("1, 8, 11, 31, 41, 42"));
            add(new Lotto("13, 14, 16, 38, 42, 45"));
            add(new Lotto("7, 11, 30, 40, 42, 43"));
            add(new Lotto("2, 13, 22, 32, 38, 45"));
            add(new Lotto("1, 3, 5, 14, 22, 45"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;

        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(winningStatisticsCalculator.calculateRateOfReturn(amount)).isEqualTo("62.5");
    }

    @DisplayName("로또 총 수익률 계산하기 - 수익이 0인 경우")
    @Test
    void calculateRateOfReturnWhenTotalPrizeIsZero() {
        int amount = 8000;
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("8, 21, 23, 41, 42, 43"));
            add(new Lotto("3, 5, 11, 16, 32, 38"));
            add(new Lotto("7, 11, 16, 35, 36, 44"));
            add(new Lotto("1, 8, 11, 31, 41, 42"));
            add(new Lotto("13, 14, 16, 38, 42, 45"));
            add(new Lotto("7, 11, 30, 40, 42, 43"));
            add(new Lotto("2, 13, 22, 32, 38, 45"));
            add(new Lotto("8, 3, 5, 14, 22, 45"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;

        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(winningStatisticsCalculator.calculateRateOfReturn(amount)).isEqualTo("0.0");
    }

    @DisplayName("로또 총 수익률 계산하기 - 수익률 둘째 자리가 5 이상인 경우 (55.55...)")
    @Test
    void calculateRoundingOver5RateOfReturn() {
        int amount = 9000;
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("8, 21, 23, 41, 42, 43"));
            add(new Lotto("3, 5, 11, 16, 32, 38"));
            add(new Lotto("7, 11, 16, 35, 36, 44"));
            add(new Lotto("1, 8, 11, 31, 41, 42"));
            add(new Lotto("13, 14, 16, 38, 42, 45"));
            add(new Lotto("7, 11, 30, 40, 42, 43"));
            add(new Lotto("2, 13, 22, 32, 38, 45"));
            add(new Lotto("1, 3, 5, 14, 22, 45"));
            add(new Lotto("8, 9, 10, 11, 12, 13"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;

        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(winningStatisticsCalculator.calculateRateOfReturn(amount)).isEqualTo("55.6");
    }

    @DisplayName("로또 총 수익률 계산하기 - 수익률 둘째 자리가 5 미만인 경우 (83.33...)")
    @Test
    void calculateRoundingUnder5RateOfReturn() {
        int amount = 12000;
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("8, 21, 23, 41, 42, 43"));
            add(new Lotto("3, 5, 11, 16, 32, 38"));
            add(new Lotto("7, 11, 16, 35, 36, 44"));
            add(new Lotto("1, 8, 11, 31, 41, 42"));
            add(new Lotto("13, 14, 16, 38, 42, 45"));
            add(new Lotto("7, 11, 30, 40, 42, 43"));
            add(new Lotto("2, 13, 22, 32, 38, 45"));
            add(new Lotto("1, 3, 5, 14, 22, 45"));
            add(new Lotto("8, 9, 10, 11, 12, 13"));
            add(new Lotto("14, 15, 16, 17, 18, 19"));
            add(new Lotto("20, 21, 22, 23, 24, 25"));
            add(new Lotto("1, 2, 7, 23, 24, 25"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;

        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(winningStatisticsCalculator.calculateRateOfReturn(amount)).isEqualTo("83.3");
    }
}
