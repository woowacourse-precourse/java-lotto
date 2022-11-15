package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoGameResult {
	private final Map<Rank, Integer> matchingResults;

	private final Money money;
	
	public LottoGameResult(final Map<Rank, Integer> matchingResults,
			final Money money) {
		this.matchingResults = new EnumMap<>(matchingResults);
		this.money = money;
	}

	public Map<Rank, Integer> getRanks() {
		Map<Rank, Integer> ranks = new EnumMap<>(matchingResults);
		ranks.remove(Rank.FAIL);
		return ranks;
	}

	public double totalInvestment() {
		return money.getValue();
	}

	public double totalWinningPrice() {
		return matchingResults.entrySet()
				.stream()
				.mapToInt(rank -> multiplyPriceByCount(rank.getKey(), rank.getValue()))
				.sum();
	}

	private int multiplyPriceByCount(Rank rank, Integer count) {
		return rank.getPrice() * count;
	}

}
