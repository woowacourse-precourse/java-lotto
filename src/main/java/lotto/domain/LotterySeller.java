package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.service.Lotto;
import lotto.util.Generator;

public class LotterySeller {
	private static List<Lotto> lotteryTickets = new ArrayList<>();

	public static List<Lotto> sellLottery(int totalNumberOfLotto) {
		for (int i = 0; i < totalNumberOfLotto; i++) {
			Generator generator = new Generator();
			lotteryTickets.add(generator.createLottery());
		}
		return lotteryTickets;
	}

	public static List<Lotto> getLotteryTickets() {
		return lotteryTickets;
	}
}
