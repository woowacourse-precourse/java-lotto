package lotto.view;

import lotto.enums.Constant;
import lotto.enums.Message;
import lotto.enums.Rank;
import lotto.model.Lotto;

import java.util.List;

public class OutputView {

	public static void printLottos(List<Lotto> lottos) {
		System.out.println("" + lottos.size() + Message.AFTER_BUY.getMessage());
		lottos.forEach(System.out::println);
	}

	public static void printPrize(List<Integer> prizes) {
		System.out.println(Message.BEFORE_PRIZE.getMessage());
		for (int rank = Rank.FIFTH.getRank(); rank >= 1; rank--) {
			int matchCount = prizes.get(rank - 1);
			Rank prize = Rank.findByRank(rank);
			System.out.println(String.format(prize.getMessage(), matchCount));
		}
	}

	public static void printProfit(List<Integer> prizes) {
		float profit = getProfit(prizes);
		String profitMessage = String.format(Message.PROFIT.getMessage(), profit);
		System.out.println(profitMessage);
	}

	private static float getProfit(List<Integer> prizes) {
		Long totalPrize = getTotalPrize(prizes);
		int totalCount = prizes.stream()
				.reduce(Integer::sum)
				.get();
		return ((float) totalPrize / (Constant.LOTTO_COST.getValue() * totalCount)) * 100;
	}

	private static Long getTotalPrize(List<Integer> prizes) {
		Long totalPrize = 0L;
		for (int rank = Rank.FIRST.getRank(); rank <= Rank.FIFTH.getRank(); rank++) {
			Rank prize = Rank.findByRank(rank);
			int count = prizes.get(rank - 1);
			totalPrize += (long) prize.getMoney() * count;
		}
		return totalPrize;
	}
}
