package lotto.domain;

import static lotto.domain.Constants.LOTTO_PRICE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

	WinningNumber winningNumber;

	public LottoStatistics(WinningNumber winningNumber) {
		this.winningNumber = winningNumber;
	}

	public Map<LottoRanking, Integer> getWinningResult(List<Lotto> lottos) {
		Map<LottoRanking, Integer> result = new HashMap<>();
		for (Lotto userLotto : lottos) {
			LottoRanking ranking = winningNumber.checkWinning(userLotto);
			result.put(ranking, result.getOrDefault(ranking, 0) + 1);
		}
		return result;
	}

	public Double calculateYield(List<Lotto> lottos, Map<LottoRanking, Integer> result) {
		double totalPrice = getTotalPrice(lottos);
		double totalReward = getTotalReward(result);
		return totalReward / totalPrice * 100;
	}

	private int getTotalPrice(List<Lotto> lottos) {
		return lottos.size() * LOTTO_PRICE;
	}

	private int getTotalReward(Map<LottoRanking, Integer> result) {
		return result.keySet()
			.stream()
			.mapToInt(ranking -> ranking.getReward() * result.getOrDefault(ranking, 0))
			.reduce(Integer::sum)
			.orElse(0);
	}
}
