package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LotterySeller {
	private static List<List<Integer>> LotteryTickets = new ArrayList<>();

	public static List<List<Integer>> sellLottery(int totalNumberOfLotto) {
		for (int i = 0; i < totalNumberOfLotto; i++) {
			Generator generator = new Generator();
			HashSet<Integer> LotteryTicket = generator.createLottery();
			List<Integer> sortedLotteryTicket = generator.sortNumber(LotteryTicket);
			LotteryTickets.add(sortedLotteryTicket);
		}
		return LotteryTickets;
	}
}
