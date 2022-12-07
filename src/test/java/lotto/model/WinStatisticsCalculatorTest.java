package lotto.model;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinStatisticsCalculatorTest {
	@DisplayName("일치번호 갯수 세기")
	@Test
	void calculateWinningStatus() {
		//	given
		LotteryMachine lotteryMachine = new LotteryMachine(8000);
		List<Lotto> lotteryTickets = lotteryMachine.getLotteryTickets();

		// List<List<Integer>> lotteryTickets = List.of(List.of(1, 2, 3, 4, 5, 7));

		Lotto winningNumbers = new Lotto(List.of(2, 3, 4, 5, 6, 8, 7));
		WinStatisticsCalculator winStatisticsCalculator = new WinStatisticsCalculator(lotteryTickets, winningNumbers);

		//	when
		winStatisticsCalculator.calculateWinningStatus();

		//	then
		// System.out.println("lotteryTickets = " + lotteryTickets);
		// System.out.println("winningNumbers = " + winningNumbers);
		// Map<Integer, Integer> result = winStatisticsCalculator.getMatchResult();
		// System.out.println("result = " + result);
	}
}
