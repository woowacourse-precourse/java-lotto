package lotto.domain;

import static lotto.domain.Constants.LOTTO_PRICE;

import java.util.LinkedList;
import java.util.List;

public class LottoStatistics {

	WinningNumber winningNumber;

	public LottoStatistics(WinningNumber winningNumber) {
		this.winningNumber = winningNumber;
	}

	public List<LottoRanking> getWinningResult(List<Lotto> lottos) {
		List<LottoRanking> result = new LinkedList<>();
		for (Lotto userLotto : lottos) {
			result.add(winningNumber.checkWinning(userLotto));
		}
		return result;
	}

	public Double calculateYield(List<Lotto> lottos, List<LottoRanking> result) {
		double totalPrice = getTotalPrice(lottos);
		double totalReward = getTotalReward(result);
		return totalReward / totalPrice * 100;
	}

	private int getTotalPrice(List<Lotto> lottos) {
		return lottos.size() * LOTTO_PRICE;
	}

	private int getTotalReward(List<LottoRanking> result) {
		return result.stream()
			.mapToInt(LottoRanking::getReward)
			.reduce(Integer::sum)
			.orElse(0);
	}
}
