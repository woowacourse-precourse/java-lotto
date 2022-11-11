package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorTest {
	@DisplayName("당첨내역과 구입금액을 입력하면 수익률을 리턴한다.")
	@Nested
	class GetProfitRateTest {
		@Test
		void case1() {
			Map<Rank, Integer> ranks = Map.ofEntries(
				Map.entry(Rank.FIRST, 0),
				Map.entry(Rank.SECOND, 0),
				Map.entry(Rank.THIRD, 0),
				Map.entry(Rank.FOURTH, 0),
				Map.entry(Rank.FIFTH, 1),
				Map.entry(Rank.MISS, 7)
			);
			int purchaseAmount = 8000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 62.5);
		}

		@Test
		void case2() {
			Map<Rank, Integer> ranks = Map.ofEntries(
				Map.entry(Rank.FIRST, 0),
				Map.entry(Rank.SECOND, 0),
				Map.entry(Rank.THIRD, 0),
				Map.entry(Rank.FOURTH, 1),
				Map.entry(Rank.FIFTH, 1),
				Map.entry(Rank.MISS, 7)
			);
			int purchaseAmount = 9000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 611.1);
		}

		@Test
		void case3() {
			Map<Rank, Integer> ranks = Map.ofEntries(
				Map.entry(Rank.FIRST, 0),
				Map.entry(Rank.SECOND, 0),
				Map.entry(Rank.THIRD, 0),
				Map.entry(Rank.FOURTH, 0),
				Map.entry(Rank.FIFTH, 0),
				Map.entry(Rank.MISS, 9)
			);
			int purchaseAmount = 9000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 0);
		}

		@Test
		void case4() {
			Map<Rank, Integer> ranks = Map.ofEntries(
				Map.entry(Rank.FIRST, 0),
				Map.entry(Rank.SECOND, 0),
				Map.entry(Rank.THIRD, 0),
				Map.entry(Rank.FOURTH, 0),
				Map.entry(Rank.FIFTH, 1),
				Map.entry(Rank.MISS, 8)
			);
			int purchaseAmount = 9000;
			ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator(ranks, purchaseAmount);
			assertEquals(profitRateCalculator.getProfitRate(), 55.6);
		}
	}
}
