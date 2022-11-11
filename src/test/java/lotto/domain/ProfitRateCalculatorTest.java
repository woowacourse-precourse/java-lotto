package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorTest {
	@DisplayName("당첨내역과 구입금액을 입력하면 수익률을 리턴한다.")
	@Nested
	class GetProfitRateTest {
		@Test
		void case1() {
			List<Integer> ranks = List.of(1, 0, 0, 0, 0);
			int purchaseAmount = 8000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 62.5);
		}

		@Test
		void case2() {
			List<Integer> ranks = List.of(1, 1, 0, 0, 0);
			int purchaseAmount = 9000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 611.1);
		}

		@Test
		void case3() {
			List<Integer> ranks = List.of(0, 0, 0, 0, 0);
			int purchaseAmount = 9000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 0);
		}

		@Test
		void case4() {
			List<Integer> ranks = List.of(1, 0, 0, 0, 0);
			int purchaseAmount = 9000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 55.6);
		}
	}
}
