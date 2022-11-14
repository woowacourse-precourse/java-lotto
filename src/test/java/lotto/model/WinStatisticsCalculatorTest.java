package lotto.model;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinStatisticsCalculatorTest {
	@DisplayName("일치번호 갯수 세기")
	@Test
	void calculateWinningStatus() {
		//	given
		LotteryMachine lotteryMachine = new LotteryMachine(8000);
		List<List<Integer>> lotteryTickets = lotteryMachine.getLotteryTickets();

		// List<List<Integer>> lotteryTickets = List.of(List.of(1, 2, 3, 4, 5, 7));

		List<Integer> winningNumbers = List.of(8, 13, 24, 27, 36, 38, 42);
		WinStatisticsCalculator winStatisticsCalculator = new WinStatisticsCalculator(lotteryTickets, winningNumbers);

		//	when
		winStatisticsCalculator.calculateWinningStatus();

		//	then
		System.out.println("lotteryTickets = " + lotteryTickets);
		System.out.println("winningNumbers = " + winningNumbers);
		Map<Integer, Integer> result = winStatisticsCalculator.getMatchResult();
	}
}
