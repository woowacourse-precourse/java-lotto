package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EarningTest {
	@Test
	@DisplayName("투입금액보다 상금이 적을때")
	void calculateEarningRateTest() {
		int money = 8000;
		long totalCashPrize = 5000;
		Earning earning = new Earning(money, totalCashPrize);
		String result = "62.5";

		assertThat(earning.getEarningRate()).isEqualTo(result);
	}

	@Test
	@DisplayName("투입금액보다 상금이 많을때")
	void calculateEarningRateTest2() {
		int money = 6000;
		long totalCashPrize = 55000;
		Earning earning = new Earning(money, totalCashPrize);
		String result = "916.7";

		assertThat(earning.getEarningRate()).isEqualTo(result);
	}

	@Test
	@DisplayName("상금이 없을때")
	void calculateEarningRateTest3() {
		int money = 6000;
		long totalCashPrize = 0;
		Earning earning = new Earning(money, totalCashPrize);
		String result = "0.0";

		assertThat(earning.getEarningRate()).isEqualTo(result);
	}
}
