package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
	@DisplayName("수익률을 구한다.")
	@Test
	void calculate() {
		ProfitCalculator profitCalculator = new ProfitCalculator();
		assertThat(profitCalculator.calculate(3000, 60000)).isEqualTo(2000);
	}
}