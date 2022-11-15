package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Earning 클래스")
class EarningTest {
	@Nested
	@DisplayName("getEarningRate 메소드는")
	class Describe_getEarningRate {
		@Nested
		@DisplayName("만약 투입금액보다 상금이 더 적다면")
		class Context_cash_prize_less_than_money {
			private final long money = 8000;
			private final long cashPrize = 5000;

			@Test
			@DisplayName("100보다 작은 수익률을 리턴한다.")
			void it_returns_under_one_hundred() {
				Earning earning = new Earning(money, cashPrize);
				String result = "62.5";

				assertThat(earning.getEarningRate()).isEqualTo(result);
			}
		}

		@Nested
		@DisplayName("만약 투입금액보다 상금이 더 많다면")
		class Context_cash_prize_more_than_money {
			private final long money = 6000;
			private final long cashPrize = 55000;

			@Test
			@DisplayName("100보다 큰 수익률을 리턴한다.")
			void it_returns_over_one_hundred() {
				Earning earning = new Earning(money, cashPrize);
				String result = "916.7";

				assertThat(earning.getEarningRate()).isEqualTo(result);
			}
		}

		@Nested
		@DisplayName("만약 상금이 0이라면")
		class Context_cash_prize_zero {
			private final long money = 6000;
			private final long cashPrize = 0;

			@Test
			@DisplayName("0을 리턴한다.")
			void it_returns_zero() {
				Earning earning = new Earning(money, cashPrize);
				String result = "0.0";

				assertThat(earning.getEarningRate()).isEqualTo(result);
			}
		}
	}
}
