package lotto.domain;

import java.util.EnumMap;

import lotto.util.Rank;

public class Prize {
	EnumMap<Rank, Integer> prizeResult;
	Long totalPrize = 0L;

	public Prize(EnumMap<Rank, Integer> prizeResult) {
		this.prizeResult = prizeResult;
	}

	public static Long getTotalPrizeMoney(EnumMap<Rank, Integer> prizeResult) {
		Prize prize = new Prize(prizeResult);
		return prize.addPrizeMoney();
	}

	public Long addPrizeMoney() {
		for (Rank rank : Rank.values()) {
			if (rank == Rank.NOTHING) {
				continue;
			}
			totalPrize += (long)rank.getMoney() * prizeResult.get(rank);
		}
		return totalPrize;
	}
}
