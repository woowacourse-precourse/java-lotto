package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.rank.Rank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    LottoCalculator calculator;
    Map<Rank, Integer> prize = new HashMap<>();

    @BeforeEach
    void setPrize() {
        for (Rank rank : Rank.values()) {
            prize.put(rank, 0);
        }
    }

    @AfterEach
    void clearPrize() {
        prize.clear();
        calculator = null;
    }

    void setPrize(Rank rank, int count) { // test 값 삽입
        prize.put(rank, prize.getOrDefault(rank, 0) + count);
    }

    void setCalculator(int amount) {
        calculator = new LottoCalculator(amount);
    }

    @Nested
    class PrizeProfitTest {
        @DisplayName("모든 등수가 한번씩 당첨되었을 때 총 당첨금")
        @Test
        void allPrizeTotalProfit_1() {
            // given
            int amount = 1_000;
            setCalculator(amount);
            for (Rank rank : Rank.values()) {
                setPrize(rank, 1);
            }
            long result = 2_031_555_000L;

            // when
            calculator.calPrizeProfit(prize);
            long profit = calculator.getTotalWinPrize();

            // then
            assertThat(profit)
                    .isEqualTo(result);
        }

        @DisplayName("모든 등수가 세번씩 당첨되었을 때 총 당첨금")
        @Test
        void allPrizeTotalProfit_2() {
            // given
            int amount = 1_000;
            setCalculator(amount);
            for (Rank rank : Rank.values()) {
                setPrize(rank, 3);
            }
            long result = 6_094_665_000L;

            // when
            calculator.calPrizeProfit(prize);
            long profit = calculator.getTotalWinPrize();

            // then
            assertThat(profit)
                    .isEqualTo(result);
        }

        @DisplayName("모든 등수가 열번씩 당첨되었을 때 총 당첨금")
        @Test
        void allPrizeTotalProfit_3() {
            // given
            int amount = 1_000;
            setCalculator(amount);
            for (Rank rank : Rank.values()) {
                setPrize(rank, 10);
            }
            long result = 20_315_550_000L;

            // when
            calculator.calPrizeProfit(prize);
            long profit = calculator.getTotalWinPrize();

            // then
            assertThat(profit)
                    .isEqualTo(result);
        }
    }

    @Nested
    class PrizeProfitRateTest {

        @DisplayName("50,000원을 쓰고 5등이 한번 당첨된 경우 수익률")
        @Test
        void profitRateTest_1() {
            // given
            int amount = 50_000;
            setCalculator(amount);
            setPrize(Rank.valueOf("FIFTH_PLACE"), 1);
            double result = 100.0;

            // when
            calculator.calPrizeProfit(prize);
            double rate = calculator.getRate();

            // then
            assertThat(rate)
                    .isEqualTo(rate);
        }

        @DisplayName("1,000,000원을 쓰고 4등이 두번 당첨된 경우 수익률")
        @Test
        void profitRateTest_2() {
            // given
            int amount = 1_000_000;
            setCalculator(amount); // 구매 금액 설정
            setPrize(Rank.valueOf("FOURTH_PLACE"), 2); // 4등 2번 당첨
            double result = 10.0;

            // when
            calculator.calPrizeProfit(prize);
            double rate = calculator.getRate();

            // then
            assertThat(rate)
                    .isEqualTo(rate);
        }

        @DisplayName("1,000원을 쓰고 1등이 한번 당첨된 경우 수익률")
        @Test
        void profitRateTest_3() {
            // given
            int amount = 1_000;
            setCalculator(amount);
            setPrize(Rank.valueOf("FIRST_PLACE"), 1);
            double result = 2_000_000.0;

            // when
            calculator.calPrizeProfit(prize);
            double rate = calculator.getRate();

            // then
            assertThat(rate)
                    .isEqualTo(rate);
        }
    }


}