package lotto.domain;

import java.util.EnumMap;
import java.util.List;

import lotto.service.Lotto;
import lotto.util.Rank;

public class WinningLotto {
	static EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
	static int matchCount = 0;
	static boolean isMatchBonusNumber = false;
	private static List<Integer> winningLotto;
	private static int bonusNumber;

	public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
		initResult();
	}

	private static void initResult() {
		for (Rank rank : Rank.values()) {
			result.put(rank, 0);
		}
	}

	public static EnumMap<Rank, Integer> produceResult(List<Lotto> lotteryTickets) {
		for (Lotto lotteryTicket : lotteryTickets) {
			new Comparison(WinningLotto.winningLotto, WinningLotto.bonusNumber);
			matchCount = Comparison.matchLottoCount(lotteryTicket);
			isMatchBonusNumber = Comparison.isMatchBonusNumber(lotteryTicket);
			putResult();
		}
		return result;
	}

	private static void putResult() {
		Rank rank = Rank.setRank(matchCount, isMatchBonusNumber);
		result.put(rank, result.get(rank) + 1);
	}

	public static EnumMap<Rank, Integer> getPrizeResult() {
		return result;
	}
}
