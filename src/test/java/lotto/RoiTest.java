package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RoiTest {
    private Roi roi;

    @Nested
    class Case1 {
        @BeforeEach
        void setUp1() {
            Integer spending = 8_000;
            List<Integer> profits = List.of(5_000);
            roi = new Roi(profits, spending);
        }

        @DisplayName("지출 8,000원, 총 당첨금 5,000원, 수익률 62.5%")
        @Test
        void percentageTest1() {
            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 62.5;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("당첨 통계: 5,000원 1회")
        @Test
        void statisticsTest1() {
            Map<Integer, Integer> actualStatistics = roi.getStatistics();
            Map<Integer, Integer> expectedStatistics = Map.of(
                    5_000, 1,
                    5_0000, 0,
                    1_500_000, 0,
                    30_000_000, 0,
                    2_000_000_000, 0
            );
            assertThat(actualStatistics).isEqualTo(expectedStatistics);
        }
    }

    @Nested
    class Case2 {
        @BeforeEach
        void setUp2() {
            Integer spending = 5_000;
            List<Integer> profits = List.of(50_000, 5_000);
            roi = new Roi(profits, spending);
        }

        @DisplayName("지출 5,000원, 총 당첨금 55,000원, 수익률 1100.0%")
        @Test
        void percentageTest2() {
            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 1100.0;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("당첨 통계: 5,000원 1회, 50,000원 1회")
        @Test
        void statisticsTest2() {
            Map<Integer, Integer> actualStatistics = roi.getStatistics();
            Map<Integer, Integer> expectedStatistics = Map.of(
                    5_000, 1,
                    5_0000, 1,
                    1_500_000, 0,
                    30_000_000, 0,
                    2_000_000_000, 0
            );
            assertThat(actualStatistics).isEqualTo(expectedStatistics);
        }
    }

    @Nested
    class Case3 {
        @BeforeEach
        void setUp3() {
            Integer spending = 8_000;
            List<Integer> profits = List.of(50_000, 5_000, 5_000, 1_500_000, 50_000, 5_000, 5_000);
            roi = new Roi(profits, spending);
        }

        @DisplayName("지출 8,000원, 총 당첨금 1,620,000원, 수익률 20,250.0%")
        @Test
        void percentageTest3() {
            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 20_250.0;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("당첨 통계: 5,000원 4회, 50,000원 2회, 1,500,000원 1회")
        @Test
        void statisticsTest3() {
            Map<Integer, Integer> actualStatistics = roi.getStatistics();
            Map<Integer, Integer> expectedStatistics = Map.of(
                    5_000, 4,
                    5_0000, 2,
                    1_500_000, 1,
                    30_000_000, 0,
                    2_000_000_000, 0
            );
            assertThat(actualStatistics).isEqualTo(expectedStatistics);
        }
    }

    @Nested
    class Case4 {
        @BeforeEach
        void setUp4() {
            Integer spending = 30_000;
            List<Integer> profits = List.of(
                    1_500_000,
                    5_000,
                    2_000_000_000,
                    5_000,
                    5_000,
                    5_000,
                    5_000,
                    5_000,
                    5_000,
                    5_000,
                    5_000,
                    5_000);
            roi = new Roi(profits, spending);
        }

        @DisplayName("지출 30,000원, 총 당첨금 2,001,550,000원, 수익률 6,671,833.3%")
        @Test
        void percentageTest4() {
            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 6_671_833.3;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("당첨 통계: 5,000원 10회, 1,500,000원 1회, 2,000,000,000원 1회")
        @Test
        void statisticsTest4() {
            Map<Integer, Integer> actualStatistics = roi.getStatistics();
            Map<Integer, Integer> expectedStatistics = Map.of(
                    5_000, 10,
                    5_0000, 0,
                    1_500_000, 1,
                    30_000_000, 0,
                    2_000_000_000, 1
            );
            assertThat(actualStatistics).isEqualTo(expectedStatistics);
        }
    }

    @Nested
    class Case5 {
        @BeforeEach
        void setUp5() {
            Integer spending = 25_000;
            List<Integer> profits = List.of(5_000, 30_000_000, 5_000, 1_500_000);
            roi = new Roi(profits, spending);
        }

        @DisplayName("지출 25,000원, 총 당첨금 31,510,000원, 수익률 126,040.0%")
        @Test
        void percentageTest5() {
            double actualReturnOnInvestment = roi.getReturnOnInvestment();
            double expectedReturnOnInvestment = 126_040.0;
            assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
        }

        @DisplayName("당첨 통계: 5,000원 2회, 1,500,000원 1회 ,30,000,000원 1회")
        @Test
        void statisticsTest5() {
            Map<Integer, Integer> actualStatistics = roi.getStatistics();
            Map<Integer, Integer> expectedStatistics = Map.of(
                    5_000, 2,
                    5_0000, 0,
                    1_500_000, 1,
                    30_000_000, 1,
                    2_000_000_000, 0
            );
            assertThat(actualStatistics).isEqualTo(expectedStatistics);
        }
    }
}