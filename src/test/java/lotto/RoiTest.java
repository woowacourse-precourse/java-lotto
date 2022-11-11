package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RoiTest {
    @Nested
    class PercentageTest {
        @DisplayName("지출 8,000원, 총 당첨금 5,000원, 수익률 62.5%")
        @Test
        void case1() {
            Integer spending = 8_000;
            List<Integer> profits = List.of(5_000);
            Roi roi = new Roi(profits, spending);

            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 62.5;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("지출 5,000원, 총 당첨금 5,000원, 수익률 100.0%")
        @Test
        void case2() {
            Integer spending = 5_000;
            List<Integer> profits = List.of(5_000);
            Roi roi = new Roi(profits, spending);

            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 100.0;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("지출 8,000원, 총 당첨금 1,550,000원, 수익률 19,375.0%")
        @Test
        void case3() {
            Integer spending = 8_000;
            List<Integer> profits = List.of(1_500_000, 50_000);
            Roi roi = new Roi(profits, spending);

            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 19_375.0;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("지출 30,000원, 총 당첨금 2,001,550,000원, 수익률 6,671,833.3%")
        @Test
        void case4() {
            Integer spending = 30_000;
            List<Integer> profits = List.of(1_500_000, 50_000, 2_000_000_000);
            Roi roi = new Roi(profits, spending);

            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 6_671_833.3;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("지출 30,000원, 총 당첨금 2,001,550,000원, 수익률 6,671,833.3%")
        @Test
        void case5() {
            Integer spending = 30_000;
            List<Integer> profits = List.of(1_500_000, 50_000, 2_000_000_000);
            Roi roi = new Roi(profits, spending);

            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 6_671_833.3;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("지출 25,000원, 총 당첨금 31,510,000원, 수익률 126,040.0%")
        @Test
        void case6() {
            Integer spending = 25_000;
            List<Integer> profits = List.of(5_000, 30_000_000, 5_000, 1_500_000);
            Roi roi = new Roi(profits, spending);

            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 126_040.0;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }
    }
}