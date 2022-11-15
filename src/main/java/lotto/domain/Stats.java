package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lotto.view.OutputView;

public class Stats {
	private static final int PERCENTAGE = 100;

	private final Map<Rank, Integer> stats;

	public Stats() {
		stats = new TreeMap<>();
		Arrays.stream(Rank.values())
			.forEach(rank -> stats.put(rank, 0));
	}

	public static Stats initStats() {
		return new Stats();
	}

	public void addLottos(List<Rank> rewards) {
		rewards.forEach(this::addLotto);
	}

	public void addLotto(Rank reward) {
		stats.put(reward, stats.get(reward) + 1);
	}

	public void print() {
		OutputView.printStats();
		stats.entrySet()
			.stream()
			.filter(rankIntegerEntry -> rankIntegerEntry.getKey() != Rank.NO_RANK)
			.forEach(rankIntegerEntry -> {
				if (rankIntegerEntry.getKey() == Rank.RANK_2ND) {
					OutputView.printSecondRankCount(rankIntegerEntry);
					return;
				}
				OutputView.printRankCount(rankIntegerEntry);
			});
	}

	public double totalReward() {
		return stats.keySet()
			.stream()
			.mapToDouble(rank -> rank.getReward() * stats.get(rank))
			.sum();
	}

	public double totalAmount() {
		return stats.values()
			.stream()
			.mapToDouble(stat -> stat)
			.sum() * ConstValue.LOTTO_PRICE;
	}

	public double yield() {
		return totalReward() / totalAmount() * PERCENTAGE;
	}
}
