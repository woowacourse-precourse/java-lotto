package lotto.domain.lotteryserver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WinningCheckerTest {
	@DisplayName("복권에 등수별로 당첨된 결과가 저장되었는지 확인") @Test void getStatisticsTest() {
		List<List<Integer>> lotto =
			Arrays.asList(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12),
				List.of(12, 43, 32, 27, 10, 8));
		List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
		List<Rank> result = WinningChecker.getStatistics(lotto, winningNumbers, 7);

		Assertions.assertThat(result.get(0)).isEqualTo(Rank.FIRST_RANK);
	}

	@DisplayName("수익률의 결과를 확인한다.") @Test void getProfitTest1() {
		List<List<Integer>> lotto =
			Arrays.asList(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12),
				List.of(12, 43, 32, 27, 10, 8));
		List<Integer> winningNumbers = Arrays.asList(1,2,3,11,12,34);
		List<Rank> result = WinningChecker.getStatistics(lotto, winningNumbers, 7);

		String profit = WinningChecker.getProfit(result, 3000);

		Assertions.assertThat(profit).isEqualTo("166.7");
	}

	@DisplayName("수익률의 숫자가 클 때 결과를 확인한다.") @Test void getProfitTest2() {
		List<List<Integer>> lotto =
			Arrays.asList(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12),
				List.of(12, 43, 32, 27, 10, 8), List.of(12, 43, 32, 2, 4, 8), List.of(12, 34, 23, 27, 11, 37));
		List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
		List<Rank> result = WinningChecker.getStatistics(lotto, winningNumbers, 7);
		String profit = WinningChecker.getProfit(result, 5000);

		Assertions.assertThat(profit).isEqualTo("40000000.0");
	}
}
