package lotto.domain.lotteryserver;

import java.util.EnumMap;
import java.util.Map;

public class RankInfo {
	private final Map<Rank, Integer> ranks;

	public RankInfo() {
		ranks = new EnumMap<>(Rank.class);
		for (Rank rank : Rank.values()) {
			ranks.put(rank, 0);
		}
	}

	public void update(Rank rank) {
		ranks.put(rank, ranks.get(rank) + 1);
	}

	public int get(Rank rank) {
		return ranks.get(rank);
	}
}
