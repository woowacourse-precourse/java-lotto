package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.util.Generator;

public class LotterySeller {
	private static List<List<Integer>> lotteryTickets = new ArrayList<>();

	public static List<List<Integer>> sellLottery(int totalNumberOfLotto) {
		for (int i = 0; i < totalNumberOfLotto; i++) {
			Generator generator = new Generator();
			lotteryTickets.add(generator.createLottery());
		}
		return lotteryTickets;
	}
}
