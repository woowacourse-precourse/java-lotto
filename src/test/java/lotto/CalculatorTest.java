package lotto;

import lotto.Model.CalculatorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private CalculatorModel calculator;

    @DisplayName("getProfit 메소드 테스트")
    @Nested
    class getProfitTest {
        @BeforeEach
        void setup() {
            calculator = new CalculatorModel();
        }

        @DisplayName("나누어 떨어지는 경우")
        @Test
        void case1() {
            int total = 5000;
            int cash = 8000;

            double actual = calculator.getProfit(total, cash);
            double result = 62.5;
            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("버리는 경우")
        @Test
        void case2() {
            int total = 10000;
            int cash = 30000;

            double actual = calculator.getProfit(total, cash);
            double result = 33.3;
            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("올리는 경우")
        @Test
        void case3() {
            int total = 5000;
            int cash = 9000;

            double actual = calculator.getProfit(total, cash);
            double result = 55.6;
            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("countLottoNumber 메소드 테스트")
    @Nested
    class countLottoNumberTest {
        @BeforeEach
        void setup() {
            calculator = new CalculatorModel();
        }

        @DisplayName("8000원")
        @Test
        void case1() {
            Cash cash = new Cash(8000);

            int actual = calculator.countLottoNumber(cash);
            int result = 8;
            assertThat(actual).isEqualTo(result);
        }

        @DisplayName("14000원")
        @Test
        void case2() {
            Cash cash = new Cash(14000);

            int actual = calculator.countLottoNumber(cash);
            int result = 14;
            assertThat(actual).isEqualTo(result);
        }
    }
}
