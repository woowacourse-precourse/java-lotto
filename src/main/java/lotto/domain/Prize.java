package lotto.domain;

import java.util.HashMap;

import lotto.util.Rank;

public class Prize {
	public static Long getTotalPrizeMoney(HashMap<Integer, Integer> result) {
		long totalPrizeMoney = 0;
		for (Rank rank : Rank.values()) {
			int key = rank.getMatchCount();
			totalPrizeMoney += (long)rank.getMoney() * result.getOrDefault(key, 0);
		}
		return totalPrizeMoney;
	}
}
