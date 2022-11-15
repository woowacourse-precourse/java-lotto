package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateOfProfitCalculatorTest {
	@DisplayName("수익률을 구한다.")
	@Test
	void calculate() {
		RateOfProfitCalculator rateOfProfitCalculator = new RateOfProfitCalculator();
		assertThat(rateOfProfitCalculator.calculate(3000, 60000)).isEqualTo(2000);
	}

	@DisplayName("매우 큰 수익률도 나타낼 수 있다.")
	@Test
	void calculateBig() {
		RateOfProfitCalculator rateOfProfitCalculator = new RateOfProfitCalculator();
		assertThat(rateOfProfitCalculator.calculate(1000, 999999999999999000L)).isEqualTo(99999999999999900L);
	}
}