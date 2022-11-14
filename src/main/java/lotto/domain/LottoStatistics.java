package lotto.domain;

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
}
