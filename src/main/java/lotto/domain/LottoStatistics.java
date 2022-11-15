package lotto.domain;

import static lotto.domain.Constants.LOTTO_PRICE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

	public static final int EMPTY_COUNT = 0;
	public static final int HUNDRED = 100;
	WinningNumber winningNumber;

	public LottoStatistics(WinningNumber winningNumber) {
		this.winningNumber = winningNumber;
	}

	public Map<LottoRanking, Integer> getWinningResult(List<Lotto> lottos) {
		Map<LottoRanking, Integer> result = new HashMap<>();
		for (Lotto userLotto : lottos) {
			LottoRanking ranking = winningNumber.checkWinning(userLotto);
			result.put(ranking, result.getOrDefault(ranking, EMPTY_COUNT) + 1);
		}
		return result;
	}

	public Double calculateYield(List<Lotto> lottos, Map<LottoRanking, Integer> result) {
		double totalPrice = getTotalPrice(lottos);
		double totalReward = getTotalReward(result);
		return totalReward / totalPrice * HUNDRED;
	}

	private int getTotalPrice(List<Lotto> lottos) {
		return lottos.size() * LOTTO_PRICE;
	}

	private int getTotalReward(Map<LottoRanking, Integer> result) {
		return result.keySet()
			.stream()
			.mapToInt(ranking -> ranking.getReward() * result.getOrDefault(ranking, EMPTY_COUNT))
			.reduce(Integer::sum)
			.orElse(EMPTY_COUNT);
	}
}
