package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import lotto.view.OutputView;

public class Stats {
	private final Map<Rank, Integer> stats;

	public Stats() {
		stats = new TreeMap<>();
		Arrays.stream(Rank.values())
			.forEach(rank -> stats.put(rank, 0));
	}

	public static Stats initStats() {
		return new Stats();
	}

	public void add(Rank reward) {
		stats.put(reward, stats.get(reward) + 1);
	}

	public void print() {
		OutputView.printStats();
		stats.entrySet().stream()
			.filter(rankIntegerEntry -> rankIntegerEntry.getKey() != Rank.NO_RANK)
			.forEach(rankIntegerEntry -> {
				if (rankIntegerEntry.getKey() == Rank.RANK_2ND) {
					OutputView.printSecondRankCount(rankIntegerEntry);
					return;
				}
				OutputView.printRankCount(rankIntegerEntry);
			});
	}

	public int totalReward() {
		return stats.keySet()
			.stream()
			.mapToInt(rank -> rank.getReward() * stats.get(rank))
			.sum();

	}
}
