package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @Nested
    @DisplayName("사용자가 입금한 금액과 당첨 금액을 통해 수익률을 계산 했을 때")
    class If_calculate_rate_of_return_by_User_input_money_and_winning_amount {

        @Test
        @DisplayName("수익률이 0%일 경우를 테스트")
        void then_rate_of_return_is_zero() {
            // given
            int totalWinningMoney = 0;
            int inputMoney = 1000;

            // when
            WinningStatistics statistics = new WinningStatistics(totalWinningMoney, inputMoney);

            // then
            Assertions.assertThat(statistics.getRateOfReturn()).isEqualTo(0);
        }

        @Test
        @DisplayName("수익률이 50%일 경우를 테스트")
        void then_rate_of_return_is_fifty() {
            // given
            int totalWinningMoney = 500;
            int inputMoney = 1000;

            // when
            WinningStatistics statistics = new WinningStatistics(totalWinningMoney, inputMoney);

            // then
            Assertions.assertThat(statistics.getRateOfReturn()).isEqualTo(50);
        }

        @Test
        @DisplayName("수익률이 62.5%일 경우를 테스트")
        void then_rate_of_return_is_sixty_two_point_five() {
            // given
            int totalWinningMoney = 5000;
            int inputMoney = 8000;

            // when
            WinningStatistics statistics = new WinningStatistics(totalWinningMoney, inputMoney);

            // then
            Assertions.assertThat(statistics.getRateOfReturn()).isEqualTo(62.5);
        }

        @Test
        @DisplayName("수익률이 100%일 경우를 테스트")
        void then_rate_of_return_is_hundred() {
            // given
            int totalWinningMoney = 5000;
            int inputMoney = 5000;

            // when
            WinningStatistics statistics = new WinningStatistics(totalWinningMoney, inputMoney);

            // then
            Assertions.assertThat(statistics.getRateOfReturn()).isEqualTo(100);
        }

        @Test
        @DisplayName("수익률이 200,000,000%일 경우를 테스트")
        void then_rate_of_return_is_one_hundred_million() {
            // given
            int totalWinningMoney = 2_000_000_000;
            int inputMoney = 1000;

            // when
            WinningStatistics statistics = new WinningStatistics(totalWinningMoney, inputMoney);

            // then
            Assertions.assertThat(statistics.getRateOfReturn()).isEqualTo(200_000_000);
        }
    }
}