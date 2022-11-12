package lotto;

import lotto.Model.CalculatorModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private CalculatorModel calculator;

    @DisplayName("calculatorProfit 메소드 테스트")
    @Nested
    class calculatorProfitTest {
        @BeforeEach
        void setup() {
            calculator = new CalculatorModel();
        }

        @Test
        void case1() {
            int totalPrize = 5000;
            int investmentCash = 8000;

            double actual = calculator.getProfit(totalPrize, investmentCash);
            double result = 62.5;
            assertThat(actual).isEqualTo(result);
        }

        @Test
        void case2() {
            int totalPrize = 10000;
            int investmentCash = 30000;

            double actual = calculator.getProfit(totalPrize, investmentCash);
            double result = 33.3;
            assertThat(actual).isEqualTo(result);
        }
    }

    @DisplayName("countLottoNumber 메소드 테스트")
    @Nested
    class countPublicationLottoTest {
        @BeforeEach
        void setup() {
            calculator = new CalculatorModel();
        }

        @Test
        void case1() {
            Cash cash = new Cash(8000);

            int actual = calculator.countLottoNumber(cash);
            int result = 8;
            assertThat(actual).isEqualTo(result);
        }

        @Test
        void case2() {
            Cash cash = new Cash(14000);

            int actual = calculator.countLottoNumber(cash);
            int result = 14;
            assertThat(actual).isEqualTo(result);
        }
    }
}
