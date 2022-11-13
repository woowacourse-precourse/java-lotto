package lotto;

import java.util.EnumMap;

public class Prize {
	static long firstPrize = Rank.FIRST.getMoney();
	static long secondPrize = Rank.SECOND.getMoney();
	static long thirdPrize = Rank.THIRD.getMoney();
	static long fourthPrize = Rank.FOURTH.getMoney();
	static long fifthPrize = Rank.FIFTH.getMoney();
	private static EnumMap<Rank, Integer> prizeResult = new EnumMap<>(Rank.class);

	public Prize() {
		prizeResult.put(Rank.FIRST, 0);
		prizeResult.put(Rank.SECOND, 0);
		prizeResult.put(Rank.THIRD, 0);
		prizeResult.put(Rank.FOURTH, 0);
		prizeResult.put(Rank.FIFTH, 0);
	}

	public static Long getTotalPrizeMoney(EnumMap<Rank, Integer> prizeResult) {
		return prizeResult.get(Rank.FIRST) * firstPrize + prizeResult.get(Rank.SECOND) * secondPrize
			+ prizeResult.get(Rank.THIRD) * thirdPrize + prizeResult.get(Rank.FOURTH) * fourthPrize
			+ prizeResult.get(Rank.FIFTH) * fifthPrize;
	}
}
