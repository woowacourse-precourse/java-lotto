package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
	private Map<Rank, Integer> result;
	private double rateOfProfit;

	public WinningResult(List<Lotto> lottos, WinningNumber winningNumber, Purchaser purchaser) {
		this.result = calculateRankResult(lottos, winningNumber);
		this.rateOfProfit = calculateRateOfProfit(result, purchaser.getPurchaseMoney());
	}

	public Map<Rank, Integer> calculateRankResult(List<Lotto> lottos, WinningNumber winningNumber) {
		Map<Rank, Integer> result = new HashMap<>();

		for(Lotto lotto : lottos) {
			Rank rank = Rank.getRank(calculateNumberOfMatching(lotto, winningNumber.getWinningLotto().getNumbers()), hasBonusNumber(lotto, winningNumber.getBounusNumber()));

			result.put(rank, result.getOrDefault(rank, 0) + 1);
		}

		return result;
	}

	public int calculateNumberOfMatching(Lotto lotto, List<Integer> winnigNumbers) {
		int numberOfMatching = 0;

		for(int number : winnigNumbers) {
			if(lotto.getNumbers().contains(number)) {
				numberOfMatching++;
			}
		}

		return numberOfMatching;
	}

	public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
		return lotto.getNumbers().contains(bonusNumber);
	}

	public int calculateProfit(Map<Rank, Integer> result) {
		return result.entrySet().stream()
				.filter(r -> r.getKey().getPrize() != 0)
				.mapToInt(r -> r.getKey().getPrize() * r.getValue())
				.sum();
	}

	public double calculateRateOfProfit(Map<Rank, Integer> result, int purchaseMoney) {
		return Math.round((double) calculateProfit(result) / (double) purchaseMoney * 1000) / 10.0;
	}

	public Map<Rank, Integer> getResult() {
		return result;
	}

	public double getRateOfProfit() {
		return rateOfProfit;
	}
}
