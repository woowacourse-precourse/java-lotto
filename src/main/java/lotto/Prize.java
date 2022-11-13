package lotto;

import java.util.EnumMap;

public class Prize {

	public Prize() {
		EnumMap<Rank, Integer> prizeResult = new EnumMap<>(Rank.class);
		prizeResult.put(Rank.FIRST, 0);
		prizeResult.put(Rank.SECOND, 0);
		prizeResult.put(Rank.THIRD, 0);
		prizeResult.put(Rank.FOURTH, 0);
		prizeResult.put(Rank.FIFTH, 0);
	}

	public static Long getTotalPrizeMoney() {
		return 91505000L;
	}
}
