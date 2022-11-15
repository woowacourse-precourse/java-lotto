package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.WinningRating;

class ProfitCalculatorTest {
	@DisplayName("수익률을 구한다.")
	@Test
	void calculate() {
		ProfitCalculator profitCalculator = new ProfitCalculator();
		EnumMap<WinningRating, Integer> countsOfWins = new EnumMap<>(WinningRating.class);
		countsOfWins.put(WinningRating.MISS, 1);
		countsOfWins.put(WinningRating.FIFTH, 0);
		countsOfWins.put(WinningRating.FOURTH, 0);
		countsOfWins.put(WinningRating.THIRD, 1);
		countsOfWins.put(WinningRating.SECOND, 0);
		countsOfWins.put(WinningRating.FIRST, 0);

		assertThat(profitCalculator.calculate(new PurchasingAmount(3000), countsOfWins)).isEqualTo(50000);
	}

	@DisplayName("매우 큰 수익률도 나타낼 수 있다.")
	@Test
	void calculateBig() {
		ProfitCalculator profitCalculator = new ProfitCalculator();
		EnumMap<WinningRating, Integer> countsOfWins = new EnumMap<>(WinningRating.class);
		countsOfWins.put(WinningRating.MISS, 2);
		countsOfWins.put(WinningRating.FIFTH, 0);
		countsOfWins.put(WinningRating.FOURTH, 0);
		countsOfWins.put(WinningRating.THIRD, 1);
		countsOfWins.put(WinningRating.SECOND, 22);
		countsOfWins.put(WinningRating.FIRST, 333);
		assertThat(profitCalculator.calculate(new PurchasingAmount(100000), countsOfWins)).isEqualTo(666661570F);
	}
}