package Service;

import lotto.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ProfitRateCalculatorTest {

    @DisplayName("9000원치 구입, 5등 1개 당첨 , 수익률 55.6%")
    @Test
    void porfitCalculator1() {
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        Map<Ranking, Integer> rankingresults = Map.of(Ranking.FIFTH, 1,
                                                    Ranking.FOURTH, 0,
                                                    Ranking.THRID, 0,
                                                    Ranking.SECOND, 0,
                                                    Ranking.FIRST, 0);

        double calculator = profitRateCalculator.calculator(9000, rankingresults);
        double result = 55.6;

        Assertions.assertThat(calculator).isEqualTo(result);
    }

    @DisplayName("130000원치 구입, 4등 1개 당첨 , 수익률 38.5%")
    @Test
    void porfitCalculator2() {
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        Map<Ranking, Integer> rankingresults = Map.of(Ranking.FIFTH, 0,
                                                    Ranking.FOURTH, 1,
                                                    Ranking.THRID, 0,
                                                    Ranking.SECOND, 0,
                                                    Ranking.FIRST, 0);

        double calculator = profitRateCalculator.calculator(130000, rankingresults);
        double result = 38.5;

        Assertions.assertThat(calculator).isEqualTo(result);
    }

    @DisplayName("30000원치 구입, 4등 1개 당첨 , 수익률 116.7%")
    @Test
    void porfitCalculator3() {
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        Map<Ranking, Integer> rankingresults = Map.of(Ranking.FIFTH, 0,
                                                    Ranking.FOURTH, 1,
                                                    Ranking.THRID, 0,
                                                    Ranking.SECOND, 0,
                                                    Ranking.FIRST, 0);

        double calculator = profitRateCalculator.calculator(30000, rankingresults);
        double result = 166.7;

        Assertions.assertThat(calculator).isEqualTo(result);
    }

}